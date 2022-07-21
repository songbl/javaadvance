package create.factory.simplefactory.store;

import create.factory.simplefactory.pizzafactory.SimplePizzaFactory;
import create.factory.simplefactory.pizza.Pizza;

/**
 *
 */
public class PizzaStore {

    SimplePizzaFactory factory ;


    //定义商店类的时候，就把生成披萨的工厂传递进来了
    public PizzaStore(SimplePizzaFactory factory){

        this.factory = factory ;
    }

    public Pizza orderPizza(String type){
        Pizza pizza ;
        //将 new 替换为工程对象创建，不在使用具体实例化
        pizza  = factory.createPizza(type);
        //再对pizza处理下
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
