package create.factory.simplefactory.pizza;

/**
 *    标准的pizza相关方法，
 *          可以直接继承使用
 *
 *
 * 抽象类或接口：定义了要创建的产品对象的接口。
 * 具体实现：具有统一父类的具体类型的产品。
 * 产品工厂：负责创建产品对象。
 * 工厂模式同样体现了开闭原则，将“创建具体的产品实现类”这部分变化的代码从不变化的代码“使用产品”中分离出来，之后想要新增产品时，只需要扩展工厂的实现即可。
 */

public  abstract class Pizza {
    public String name;

   public void prepare(){
        System.out.println("Prepareing "+name);
    }
    public   void bake(){
         System.out.println("bake "+"15到20分钟的样子");
     }
    public  void cut(){
         System.out.println("cut "+"标准切割行..");
     }
    public   void box(){
         System.out.println("box "+"标准的装");
     }

    public String getName() {
        return name;
    }
}
