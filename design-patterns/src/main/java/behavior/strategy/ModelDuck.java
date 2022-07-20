package behavior.strategy;

public class ModelDuck extends Duck {

    public ModelDuck(){
        flyBehavior = new FlyNoWings();//委托类，不会飞的假鸭子
    }
    @Override
    public void display() {
        System.out.println("我是模型鸭子...");
    }
}
