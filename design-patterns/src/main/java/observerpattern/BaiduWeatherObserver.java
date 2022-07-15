package observerpattern;

/**
 * 百度天气 观察者，需要更新中央的天气
 *
 */
public class BaiduWeatherObserver implements Observer,DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;



    @Override
    public void update(float temp, float hunidity, float pressure) {
        this.humidity = hunidity;
        this.temperature = temp ;
        this.pressure = pressure ;
        display();
    }

    @Override
    public void updateByPull(Subject subject) {

    }

    @Override
    public void display() {


        System.out.println("百度天气：天气改变了.温度改变了当前温度："+temperature+"当前湿度："+humidity+"当前压强："+pressure);

    }











}
