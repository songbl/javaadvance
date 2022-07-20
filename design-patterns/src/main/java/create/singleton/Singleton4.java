package create.singleton;

/**
 * lazy loading
 * 懒汉式
 * 通过加锁来解决线程不安全的问题，但是效率下降了
 */
public class Singleton4 {
    private static Singleton4 INSTANCE;

    private Singleton4() { }

    public static synchronized Singleton4 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton4();
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
                    System.out.println(Singleton4.getInstance().hashCode())
            ).start();
        }
    }
}
