package behavior.strategy;

/**
 *  委托   不会飞的假鸭子，（飞行动作都是由委托类完成）
 *
 *  这也是一个算法族，没有翅膀的飞行的算法族
 */
public class FlyNoWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("假的，我不会飞....");
    }
}
