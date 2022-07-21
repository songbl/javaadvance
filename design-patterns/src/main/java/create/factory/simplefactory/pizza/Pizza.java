package create.factory.simplefactory.pizza;

/**
 *    标准的pizza相关方法，
 *          可以直接继承使用
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
