package create.factory.factorymethod.pizza;


import create.factory.simplefactory.pizza.Pizza;

public class NewYorkStyleCheesePizza extends Pizza {


    public NewYorkStyleCheesePizza(){
        name = "纽约类型奶酪披萨";
    }

    @Override
    public void prepare() {
        System.out.println("纽约类型奶酪披萨..准备");
    }

    @Override
    public void bake() {
        System.out.println("纽约类型奶酪披萨..烘烤");
    }

    @Override
    public void cut() {
        System.out.println("纽约类型奶酪披萨..切割");
    }

    @Override
    public void box() {
        System.out.println("纽约类型奶酪披萨..打包");
    }


}
