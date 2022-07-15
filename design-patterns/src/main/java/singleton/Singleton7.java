package singleton;

/**
 *
 *  枚举，天生单例
 *      可用
 *
 *
         */
public enum  Singleton7 {

    INSTANCE;

    //hashCode 一样了
    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->
                    System.out.println(Singleton7.INSTANCE.hashCode())
            ).start();
        }
    }
}
