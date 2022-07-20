package behavior.strategy.improve;

import behavior.strategy.Duck;

public class Client {
    public static void main(String[] args) {
        Duck duck = DuckFactory.getDcuk(KindEnum.MODELDUCK);
        duck.display();
        duck.performFly();
    }
}
