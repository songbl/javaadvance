package behavior.template;

/**
 * 咖啡因饮料（茶喝咖啡）
 * 了解和控制冲泡的步骤，亲自完成步骤1和3。
 * 依赖茶喝咖啡完成的步骤2和4他们自己实现
 * ====================================================
 * 模板方法定义一个 **算法步骤**，并允许子类为一个或多个步骤提供实现
 * 制定的算法步骤是最核心的
 * ====================================================
 */
public abstract class CaffeineBeverage {
    //定义为final,不希望子类覆盖这个方法，再将步骤2和步骤4泛化（子类具体处理，根不变）
    /**
     *  prepareRecipe是一个模板方法；它用作一个算法的模板
     *  这个例子，  算法    是用来制作咖啡因饮料的。
     *  在这个模板中，算法的每一个步骤都被一个方法代表了
     *  某些方法由该类处理，某些方法由具体的子类处理
     */
    final void prepareRecipe(){
        boilWater();
        brew();//弄茶还是咖啡（泛化该步骤）
        pourInCup();
        if (customerWantsCondiments()){//添加钩子，有默认实现，子类可以选择覆盖
            addCondiments();//往茶或者咖啡中加入佐料
        }
    }
    //高层组件决定何时调用低层组件；这时候就调用低层组件了
    abstract void brew();//咖啡，喝茶处理这个步骤做法不同，所以抽象，子类具体实现


    abstract void addCondiments();


    //相同的方法，直接实现好了就ok
    void boilWater(){
        System.out.println("父类默认的实现 - 烧开水...");
    }

    //相同的方法，直接实现好了就ok
    void pourInCup(){
        System.out.println("父类默认的实现 - 倒进杯子里面...");
    }

    /**
     * 某些步骤是可选的，可以将
     * 钩子方法，有默认的实现，子类可以选择是否覆盖
     * 一般情况是  空  实现
     */
    boolean customerWantsCondiments(){
        return true;
    }
}
