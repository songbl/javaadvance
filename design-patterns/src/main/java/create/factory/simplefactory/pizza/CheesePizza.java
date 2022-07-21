package create.factory.simplefactory.pizza;

public class CheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("准备奶酪披萨");
    }

    @Override
    public void bake() {
        System.out.println("烘烤奶酪披萨");
    }

    @Override
    public void cut() {
        System.out.println("切割奶酪披萨");
    }

    @Override
    public void box() {
        System.out.println("包装奶酪披萨");
    }



    public void systemOut(String s){
        System.out.println(s);
    }
}
