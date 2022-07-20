package behavior.template;

/**
 * 工序相同的继承即可，工序不同的自己具体去实现
 */
public class Tea extends CaffeineBeverage {

    @Override
    void boilWater() {
        System.out.println("复写默认的实现，烧开纯净水");
    }

    @Override
    void brew() {
        System.out.println("热水冲泡茶");
    }
    @Override
    void addCondiments() {
        System.out.println("茶中加入柠檬");
    }

    @Override
    public boolean customerWantsCondiments(){
        return  false;//简单实现（喝茶用户不加佐料）
    }
}
