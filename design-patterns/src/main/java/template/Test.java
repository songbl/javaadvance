package template;

public class Test {

    public static void main(String[] args) {

        Tea myTea = new Tea();
        /**
         * 子类调用父类的方法，
         *                       final void prepareRecipe(){
         *                                   boilWater();
         *                                  brew();//热水冲泡茶或者咖啡（泛化该步骤）
         *                                   pourInCup();
         *                                  if (customerWantsCondiments()){//添加钩子，有默认实现，子类可以选择覆盖
         *                                  addCondiments();//往茶或者咖啡中加入佐料
         *                                   }
         *                               }
         *     然后执行 boilWater()等方法，如果子类复写了，那么执行子类自己的，如果没有复写，执行父类的呢
         *     最后，可以定义成抽象方法，那么子类就必须复写了
         */
        myTea.prepareRecipe();
        //高层组件决定何时调用低层组件
        //myTea.brew();//该方法依赖倒置了，违反好莱坞原则。低层组件依赖高层组件

    }
}
