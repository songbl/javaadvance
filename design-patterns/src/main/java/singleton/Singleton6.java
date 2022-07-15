package singleton;

/**
 *  通过静态内部类实现，JVM 保证单例
 *  加载外部类的时候不会加载内部类，可以实现懒加载
 *              可用
 *
 *
         */
public class Singleton6 {

    private Singleton6() { }


    private static class Singleton6Holder {
        private final static Singleton6 INSTANCE = new Singleton6();
    }


    public static Singleton6 getInstance() {
        return Singleton6Holder.INSTANCE;
    }


    //hashCode 一样了
    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->
                    System.out.println(Singleton6.getInstance().hashCode())
            ).start();
        }
    }
}
