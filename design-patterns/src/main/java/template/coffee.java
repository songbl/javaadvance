package template;

public class coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("热水冲泡咖啡");
    }

    @Override
    void addCondiments() {
        System.out.println("咖啡中加入糖");
    }
}
