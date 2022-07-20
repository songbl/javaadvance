package construction.adapter;

public class Test {
    public static void main(String[] args) {
        PowerTarget target = new PowerAdapter();
        target.output5V();
    }


}
