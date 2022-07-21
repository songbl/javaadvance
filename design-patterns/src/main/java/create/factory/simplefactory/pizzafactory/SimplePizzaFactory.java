package create.factory.simplefactory.pizzafactory;

import create.factory.simplefactory.pizza.CheesePizza;
import create.factory.simplefactory.pizza.ClamPizza;
import create.factory.simplefactory.pizza.Pizza;
import create.factory.simplefactory.pizza.VegetablePizza;

/**
 *  只干一件事：帮它的客户创建披萨
 *
 *
 *
 * 将创建的代码部分搬到另一个对象中，这个新的对象只管如何创建披萨。新对象就是工厂
 *
 *
 *
 *  通常是静态方法（也叫做静态工厂，只需要一个工厂类的使用，在生产产品的方法加上static）
 *  简单工厂其实并不是一个设计模式，而是一种习惯。
 */
public class SimplePizzaFactory {


    //变化的部分，封装起来，如下..
    public Pizza createPizza(String type){
        Pizza pizza = null ;
        if (type.equals("cheese")){
            pizza = new CheesePizza();
        }else if (type.equals("clam")){
            pizza = new ClamPizza();
        }else  if (type.equals("vegetable")){
            pizza = new VegetablePizza();
        }
        return pizza;
    }

    //静态工厂
    public static Pizza staticCreatePizza(String type){
        Pizza pizza = null ;
        if (type.equals("cheese")){
            pizza = new CheesePizza();
        }else if (type.equals("clam")){
            pizza = new ClamPizza();
        }else  if (type.equals("vegetable")){
            pizza = new VegetablePizza();
        }
        return pizza;
    }
}
