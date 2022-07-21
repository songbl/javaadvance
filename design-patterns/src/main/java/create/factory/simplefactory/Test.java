package create.factory.simplefactory;

import create.factory.simplefactory.pizza.Pizza;
import create.factory.simplefactory.pizzafactory.SimplePizzaFactory;
import create.factory.simplefactory.store.PizzaStore;

public class Test {
    public static void main (String args[]){
//        Pizza pizza = new SimplePizzaFactory().createPizza("vegetable");
//        pizza.cut();

        //简单工厂
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        //订购素菜口味的披萨
        pizzaStore.orderPizza("vegetable");


        //简单工厂
        Pizza pizza = SimplePizzaFactory.staticCreatePizza("cheese");
        //再对pizza处理下
        pizza.cut();





//        PizzaStoreNew nytore = new NeWYorkPizzaStoreFactory();
//
//        Pizza pizza = nytore.orderPizza("cheese");
//        System.out.println("小龙订购一个"+pizza.getName());




    }
}

