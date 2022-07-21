package create.factory.abstractfactory;

public class DellMonitor implements Monitor {
    @Override
    public void display() {
        System.out.println("戴尔显示器");
    }
}