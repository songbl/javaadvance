package behavior.strategy;

public class FlyRocketPower implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("提供火箭动力....助力假鸭子飞飞.....");
    }
}
