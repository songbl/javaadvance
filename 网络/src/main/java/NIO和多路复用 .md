#### 1.BIO
BIO即为阻塞IO的意思，通常我们讲BIO的时候都会和服务器模型配合着讲，在实际应用中讲会更好理解。
下例是服务端代码，包括：
    * 建立连接，绑定端口
    * 监听状态
    * 接受客户端的请求
```java
public static void main(String[] args) throws Exception {
    //建立socket，socket是客户端和服务器沟通的桥梁
    ServerSocket server = new ServerSocket(9090,20);
    //通过死循环不断接收客户端请求
    while (true) {
        //线程会阻塞在这行的accep方法
        Socket client = server.accept(); 
        //创建新线程处理新客户端的逻辑
        new Thread(() -> {
            //client的读写逻辑
        }).start();
    }
}
```
1. 只要没有客户端连接上服务器，**accept方法**就一直不能返回，这就是**阻塞**；
2. 对应的读写操作道理也一样，想要**读取数据**，必须等到有数据到达才能返回，这就是**阻塞**。
###### 1.1 BIO导致的问题：
我们还可以站在阻塞的基础上思考一下，为什么服务器的模型要设计成来一个客户端就新建一个线程？
其实答案很简单，当来了一个客户端创建连接后，如果不给客户端新分配一个线程执行服务器逻辑，那么**服务端将很难再和第二个客户端建立连接**。

我们以一种C10K的思想去看待上面这段服务器代码。如果我们客户端的连接数增加了10K倍，那么就意味着要创建10k个线程，单单创建线程就是一项不小的开销了，再加上线程之间要来回切换，单机服务器根本就扛不住这么大的连接数。

#### 1.NIO
那既然瓶颈是出在线程上，我们就**考虑能不能把服务器的模型变为单线程模型**，思路其实和之前说的差不多，用集合保存每个连接的客户端，通过while循环来对每个连接进行操作。

之前我们说了这样的操作瓶颈在于accept客户端的时候会阻塞，以及进行读写操作的时候会阻塞，导致单线程执行效率低。为了突破这个瓶颈，操作系统发展出了nio，这里的nio指的是非阻塞io。（Java里面的NIO 是 New IO）

也就是说在accept客户端连接的时候，不需要阻塞，如果没有客户端连接就返回-1（java-NULL），在读写操作的时候，也不阻塞，有数据就读，没数据就直接返回，这样就解决了单线程服务器的瓶颈问题。(**客户端和服务端建立多个socket，建立连接并不阻塞**)

示例代码如下：

```java
public static void main(String[] args) throws Exception {
    //用于存储客户端的集合
    LinkedList<SocketChannel> clients = new LinkedList<>();
    //nio里概念改成了channel
    ServerSocketChannel ss = ServerSocketChannel.open();
    ss.bind(new InetSocketAddress(9090));
    //设置成非阻塞
    ss.configureBlocking(false);
    while (true) {
        //调用accept()方法时如果通道配置为非阻塞模式,那么accept()方法立即返回null，并不阻塞
        SocketChannel client = ss.accept();
        if (client == null) {
            System.out.println("null.....");      
        } else {
            //设置客户端操作也为非阻塞
            client.configureBlocking(false); 
            clients.add(client);
        }
        ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
        //遍历已经链接进来的客户端能不能读写数据（伪代码）
        for (SocketChannel c : clients) {
            int num = c.read(buffer);
            if (num > 0) {
                //其他操作
            }
        }
    }
}
```
##### 2.1 NIO的问题：
每次会循环1w次调用系统内核，看下有没有数据，也就是说每次循环会有O(n)复杂度的sys call的过程，但是可能1w次中只有几个是有数据或者说是准备就绪的，也就是绝大多数的系统调用都是白忙活的，这有点浪费资源了吧！
#### 2.多路复用器
在上面的代码中每次循环遍历都进行读写操作，我们以读操作为例：大部分读操作都是在数据没有准备好的情况下进行读的，相当于执行了一次空操作。我们要想办法避免这种无效的读取操作，避免内核态和用户态之间的频繁切换。

为了避免上述的无效读写，我们得想办法得知当前的文件描述符是否可读可写。**如果逐个文件描述符去询问，那么效率就和直接进行读写操作差不多了**，我们希望有一种方法能够一次性得知哪些文件描述符可读，哪些文件描述符可写，这，就操作系统后来发展出的多路复用器。
也就是说，**多路复用器的核心功能就是告诉我们哪些文件描述符可读，哪些文件描述符可写**。
##### 2.1 select和poll 模型
而多路复用器也分为几种，他们也经历了一个演化的过程。最初的多路复用器是`select`模型，它的模式是这样的：程序端每次把文件描述符集合交给select的系统调用，select遍历每个文件描述符后返回那些可以操作的文件描述符，然后程序对可以操作的文件描述符进行读写（**把文件描述符打包一次丢给内核-Kernel，内核会返回若干个可用状态的文件描述符，最终读数据是基于这若干个可用状态的文件描述符访问内核去读**）。
`select`的弊端是，一次传输的文件描述符集合有限，只能给出1024个文件描述符，poll在此基础上进行了改进，没有了文件描述符数量的限制。
但是`select`和`poll`在性能上还可以优化，它们共同的**弊端**在于：
它们需要**在内核中对所有传入的文件描述符进行遍历**，这也是一项比较耗时的操作
（这点是否存在优化空间有待考证）每次要把文件描述符从用户态的内存搬运到内核态的内存，遍历完成后再搬回去，这个来回复制也是一项耗时的操纵。
后来操作系统加入了epoll这个多路复用器，彻底解决了这个问题。
##### 2.2 epoll
epoll多路复用器的模型是这样的：为了在发起系统调用的时候不遍历所有的文件描述符，epoll的优化在于：当数据到达网卡的时候，会触发中断，正常情况下cpu会把相应的数据复制到内存中，和相关的文件描述符进行绑定。epoll在这个基础之上做了延伸，epoll首先是在内核中维护了一个红黑树，以及一些链表结构，当数据到达网卡拷贝到内存时会把相应的文件描述符从红黑树中拷贝到链表中，这样链表存储的就是已经有数据到达的文件描述符，这样当程序调用epoll_wait的时候就能直接把能读的文件描述符返回给应用程序。

除了epoll_wait之外，epoll还有两个系统调用，分别是epoll_create和epoll_ctl，分别用于初始化epoll和把文件描述符添加到红黑树中。
**参考**：[https://mp.weixin.qq.com/s?src=11&timestamp=1660612663&ver=3985&signature=tAJeVgZXzZ0*4IEZKVoVZ2hrIvIxTdGEOzFtocyQyqFmU7aOuTxu8tCCt0su41PiTy77esCAc*tM54AUMh-k26YbQn*1S4KPiha8FkFzrQ98ISl83-GjxFLmxUf*zyC2&new=1](https://mp.weixin.qq.com/s?src=11&timestamp=1660612663&ver=3985&signature=tAJeVgZXzZ0*4IEZKVoVZ2hrIvIxTdGEOzFtocyQyqFmU7aOuTxu8tCCt0su41PiTy77esCAc*tM54AUMh-k26YbQn*1S4KPiha8FkFzrQ98ISl83-GjxFLmxUf*zyC2&new=1)