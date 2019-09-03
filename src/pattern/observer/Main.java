package pattern.observer;

import pattern.observer.display.CurrentConditionsDisplay;
import pattern.observer.display.ForecastDisplay;
import pattern.observer.display.StatisticsDisplay;
import pattern.observer.subject.WeatherData;

/**
 * @Descript: 观察者模式:定义了对象之间的一对多依赖，这样一来，当一个对象发生状态改变时，其它所有依赖对象都会收到通知斌自动跟新
 * @Author: zhouwei
 * @Date: 19-6-10 下午5:42
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        //取消订阅
        weatherData.removeObserver(currentDisplay);
        weatherData.removeObserver(statisticsDisplay);
        weatherData.setMeasurements(78, 90, 29.2f);

    }

}
