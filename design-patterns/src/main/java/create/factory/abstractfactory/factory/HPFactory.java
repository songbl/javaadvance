package create.factory.abstractfactory.factory;

import create.factory.abstractfactory.*;

public class HPFactory implements IFactory {
    @Override
    public MainFrame createMainFrame(){
        MainFrame mainFrame = new HPMainFrame();
        //...造一个HP主机;
        return mainFrame;
    }

    @Override
    public Monitor createMonitor(){
        Monitor monitor = new HPMonitor();
        //...造一个HP显示器;
        return monitor;
    }

    @Override
    public Keyboard createKeyboard(){
        Keyboard keyboard = new HPKeyboard();
        //...造一个HP键盘;
        return keyboard;
    }
}