package strategy;

/**
 *具体的某个鸭子了
 */
public class MallardDuck extends Duck {
    public MallardDuck(){//初始化就完成委托类..
        flyBehavior = new FlyWithWings();//多态呢，运行时候，执行FlyWithWings的方法。
    }

    @Override
    public void display() {
        System.out.println("我是一个小麻鸭..");
    }
}
