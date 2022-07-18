package strategy;

/**
 * 飞行接口（不同鸭子类型，不同的飞行方式）
 *  ===这就是哪个算法族=====实现这个接口的类  =======相互替换
 */
public interface FlyBehavior {
    public void fly();
}
