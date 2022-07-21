package create.factory.abstractfactory.factory;


//工厂类。工厂分为Dell工厂和HP工厂，各自负责品牌内产品的创建


import create.factory.abstractfactory.Keyboard;
import create.factory.abstractfactory.MainFrame;
import create.factory.abstractfactory.Monitor;

public interface IFactory {

    Keyboard createKeyboard();
    MainFrame createMainFrame();
    Monitor createMonitor();

    //如果增加鼠标的话，那么修改将非常的大


}
