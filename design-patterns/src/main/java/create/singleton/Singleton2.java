package create.singleton;

/**
 *  给例子1 是一个意思，实现的方式小变一下，原理是一样的
 *          可用
 */

public class Singleton2 {
    private static final Singleton2 INSTANCE;
    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {};

    public static Singleton2 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1 == s2);
    }


}
