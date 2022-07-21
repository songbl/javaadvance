package create.factory.factorymethod;

import create.factory.factorymethod.pizza.NewYorkStyleCheesePizza;
import create.factory.factorymethod.pizza.NewYorkStyleVegetablePizza;
import create.factory.simplefactory.pizza.Pizza;

/**
 * 很像简单工厂。
 * 简单工厂把所有的事情都在子类做做完，
 *
 * 这是具体的工厂，创建属于自己的产品
 */


/**
 * 如果使用简单工厂，新增一个产品，就要修改工厂，这里不是了
 * 不要修改工厂，而是新增工厂，符合开闭原则（不过这个工厂下面新增产品还是要改，只是大类不需要改了）
 *
 */

public class NeWYorkPizzaStoreFactory extends PizzaStoreNew {
    Pizza pizza ;

    /**
     *  具体生产某个产品(该例是pizza)，延迟到了具体的子类中（多态）
     *  具体的工厂方法，生产具体的产品
     */
    @Override
   public Pizza createPizza(String type) {
       if (type.equals("cheese")){
           pizza = new NewYorkStyleCheesePizza();
       }else  if (type.equals("vegetable")){
           pizza = new NewYorkStyleVegetablePizza();
       }
       return  pizza;
    }


}

/**
 *每一种品牌对应一个工厂子类，在创建具体键盘对象时，实例化不同的工厂子类。但是，如果业务涉及的子类越来越多
 *
 *
 * public interface IKeyboardFactory {
 *     Keyboard getInstance();
 * }
 *
 * public class HPKeyboardFactory implements IKeyboardFactory {
 *     @Override
 *     public Keyboard getInstance(){
 *         return new HPKeyboard();
 *     }
 * }
 *
 * public class LenovoFactory implements IKeyboardFactory {
 *     @Override
 *     public Keyboard getInstance(){
 *         return new LenovoKeyboard();
 *     }
 * }
 *
 * public class DellKeyboardFactory implements IKeyboardFactory {
 *     @Override
 *     public Keyboard getInstance(){
 *         return new DellKeyboard();
 *     }
 * }
 *
 */
