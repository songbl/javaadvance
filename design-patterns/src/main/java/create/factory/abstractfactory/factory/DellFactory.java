package create.factory.abstractfactory.factory;

import create.factory.abstractfactory.*;

/**
 *
 * 这里面是一个产品族
 *
 */


public class DellFactory implements IFactory {

    @Override
    public MainFrame createMainFrame(){
        MainFrame mainFrame = new DellMainFrame();
        //...造一个Dell主机;
        return mainFrame;
    }

    @Override
    public Monitor createMonitor(){
        Monitor monitor = new DellMonitor();
        //...造一个Dell显示器;
        return monitor;
    }

    @Override
    public Keyboard createKeyboard(){
        Keyboard keyboard = new DellKeyboard();
        //...造一个Dell键盘;
        return keyboard;
    }
}
