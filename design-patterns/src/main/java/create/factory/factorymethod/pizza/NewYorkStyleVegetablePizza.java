package create.factory.factorymethod.pizza;


import create.factory.simplefactory.pizza.Pizza;

public class NewYorkStyleVegetablePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("纽约风味蔬菜..准备");
    }

    @Override
    public void bake() {
        System.out.println("纽约风味蔬菜..烘烤");
    }

    @Override
    public void cut() {
        System.out.println("纽约风味蔬菜..切割");
    }

    @Override
    public void box() {
        System.out.println("纽约风味蔬菜..打包");
    }
}
