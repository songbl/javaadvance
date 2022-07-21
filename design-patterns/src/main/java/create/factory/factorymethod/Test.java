package create.factory.factorymethod;

import create.factory.simplefactory.pizza.Pizza;

public class Test {
    public static void main (String args[]){



        //工厂方法
        Pizza pizza1 = new NeWYorkPizzaStoreFactory().createPizza("cheese");
        System.out.println(pizza1.getName());

        //有好几个工厂，纽约，巴黎...;
        //每个工厂只创建一类产品，其实更加细化了代码
        Pizza pazz2 = new NeWYorkPizzaStoreFactory().orderPizza("vegetable");
        pazz2.cut();






    }
}

