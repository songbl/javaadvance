package behavior.observer;

public class Test {
    public static void main(String[] args) {
        //先创建被观察者（主题），没有主题观察毛啊
        WeatherDataSubject weatherDataSubject = new WeatherDataSubject();

        //创建观察者
        BaiduWeatherObserver baiduWeatherObserver = new BaiduWeatherObserver();
        XinLangWeatherObserver xinLangWeatherObserver = new XinLangWeatherObserver();

        //订阅
        weatherDataSubject.registerObserver(baiduWeatherObserver);
        weatherDataSubject.registerObserver(xinLangWeatherObserver);

        //解除绑定
//        weatherDataSubject.registerObserver();

        //主题数据变更
        weatherDataSubject.setData(20f,21f,22f);

        //通知更新数据
        weatherDataSubject.notifyObserver();

    }

    }
