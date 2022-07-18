package strategy;

/**
 *
 *    =========我们需要一切能有弹性=======   我们应该在鸭子类中包含设定行为的方法，可以在【运行时】
 * 动态地改变绿头鸭的飞行行为。
 *
 *      =======分开变与不变的部分=======
 *
 *    飞行方法需要特别的变化..
 *
 *
 *
 */
public abstract class Duck {

    FlyBehavior flyBehavior ;//多态

    public Duck(){}

    public abstract void display();//每个鸭子都有的，每个鸭子都要实现（理解为不变的）

    public void performFly(){  //鸭子的飞行方式是变化的....各种飞....翅膀、挂火箭..
        flyBehavior.fly();
    }


    //动态设置鸭子的飞行行为
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }


}

