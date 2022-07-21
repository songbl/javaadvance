package create.factory.simplefactory.pizza;

public class ClamPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备蛤蜊披萨");
    }

    @Override
    public void bake() {
        System.out.println("烘烤蛤蜊披萨");
    }

    @Override
    public void cut() {
        System.out.println("切割蛤蜊披萨");
    }

    @Override
    public void box() {
        System.out.println("包装蛤蜊披萨");
    }
    public void systemOut(String s){
        System.out.println(s);
    }
}
