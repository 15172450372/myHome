package pattern.observerPattern.display;

import pattern.observerPattern.subject.Subject;

/**
 * @Descript:
 * @Author: zhouwei
 * @Date: 19-6-10 下午6:39
 * @Version 1.0
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registryObserver(this);
    }

    @Override
    public void display() {
        System.out.println("StatisticsDisplay: temperature=" + temperature + " humidity=" + humidity + " pressure" + pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }



}
