package behavior.strategy.improve;

import behavior.strategy.Duck;
import behavior.strategy.MallardDuck;
import behavior.strategy.ModelDuck;

import java.util.HashMap;
import java.util.Map;

public class DuckFactory {

    /**
     * 有些是直接实现了策略算法
     *  这里是标准版本，使用的抽象类，又多了一层
     */

    private static final Map<KindEnum, Duck> duckStrategies = new HashMap<>();

    static {
        duckStrategies.put(KindEnum.MODELDUCK, new ModelDuck());
        duckStrategies.put(KindEnum.MALLARDDUCK, new MallardDuck());
    }

    public static Duck getDcuk(KindEnum kindEnum) {
        if (kindEnum == null) {
            throw new IllegalArgumentException("pay type is empty.");
        }
        if (!duckStrategies.containsKey(kindEnum)) {
            throw new IllegalArgumentException("pay type not supported.");
        }
        return duckStrategies.get(kindEnum);
    }

}
