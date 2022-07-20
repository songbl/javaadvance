package create.singleton;
/**
* 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
* 简单实用，推荐使用！
* 唯一缺点：不管用到与否，类装载时就完成实例化
* Class.forName("")
*     可用
        */
public class Singleton1 {
    private static final Singleton1 instance = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return instance;
    }

    public static void main(String[] args) {

        //测试
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();
        System.out.println(instance1 == instance2);//true

    }
}


