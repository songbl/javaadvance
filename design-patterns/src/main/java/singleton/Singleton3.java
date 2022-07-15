package singleton;

/**
 * lazy loading
 * 懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 */
public class Singleton3 {
    private static Singleton3 INSTANCE;

    private Singleton3() { }

    public static Singleton3 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    //hashCode 不一样了
    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->
                    System.out.println(Singleton3.getInstance().hashCode())
            ).start();
        }
    }
}
