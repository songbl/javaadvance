package create.singleton;

/**
 * lazy loading
 *  通过双重检查来保证线程安全，同时提高了程序性能
 *      可用
 */
public class Singleton5 {
    private static volatile Singleton5 INSTANCE;

    private Singleton5() { }

    public static  Singleton5 getInstance() {
        if (INSTANCE == null) {
            //双重检查
            synchronized (Singleton5.class) {
                if (INSTANCE==null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton5();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    //hashCode 一样了
    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->
                    System.out.println(Singleton5.getInstance().hashCode())
            ).start();
        }
    }
}
