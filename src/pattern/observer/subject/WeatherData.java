package pattern.observer.subject;

import pattern.observer.display.Observer;

import java.util.ArrayList;

/**
 * @Descript:
 * @Author: zhouwei
 * @Date: 19-6-10 下午6:11
 * @Version 1.0
 */
public class WeatherData implements Subject {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registryObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer1 : observers) {
            observer1.update(temperature, humidity, pressure);
        }
    }

    public void meassurementChanged() {
        notifyObservers();
    }
    
    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        meassurementChanged();
    }

}
