package behavior.observer;

import java.util.ArrayList;

public class WeatherDataSubject implements Subject {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;


    public WeatherDataSubject(){//初始化的时候，构造容器，记录观察者
        observers = new ArrayList();
    }
    @Override
    public void registerObserver(Observer o) {//当注册的时候，将观察者加进容器
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o) {//取消订阅的时候，将观察者从容器中删除
        int i = observers.indexOf(o);
        if (i>=0){
            observers.remove(i);
        }
    }
    @Override
    public void notifyObserver() {
        for (int i =0;i<observers.size();i++){
            Observer observer = observers.get(i);
            observer.update(temperature,humidity,pressure);//将更新后的数据告诉每一观察者
        }
    }

    public void  datasChanged(){//数据发生改变，通知观察者
        notifyObserver();
    }

    public void setDatasByPull(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        datasChanged();
    }

    public void setData(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }
    public float getPressure() {
        return pressure;
    }
    public float getTemperature() {
        return temperature;
    }


}
