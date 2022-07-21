package create.factory.abstractfactory;

import create.factory.abstractfactory.factory.DellFactory;
import create.factory.abstractfactory.factory.HPFactory;
import create.factory.abstractfactory.factory.IFactory;
public class client {
    public static void main(String[] args) {

        //客户端代码。
        // 实例化不同的工厂子类，可以通过不同的创建方法创建不同的产品

        IFactory dellFactory = new DellFactory();

        IFactory HPFactory = new HPFactory();

        //创建戴尔键盘
        Keyboard dellKeyboard = dellFactory.createKeyboard();
        //...
    }
}
