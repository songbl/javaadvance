package create.factory.simplefactory.pizza;

import create.factory.simplefactory.pizza.Pizza;

public class VegetablePizza extends Pizza {
    @Override
    public void prepare() {
        systemOut("准备蔬菜披萨");
    }

    @Override
    public void bake() {
        systemOut("烘烤蔬菜披萨");
    }

    @Override
    public void cut() {
        systemOut("切割蔬菜披萨");
    }

    @Override
    public void box() {
        systemOut("包装蔬菜披萨");
    }
    public void systemOut(String s){
        System.out.println(s);
    }
}
