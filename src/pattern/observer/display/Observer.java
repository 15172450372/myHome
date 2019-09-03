package pattern.observer.display;

/**
 * 订阅者
 */
public interface Observer {

    /**
     * 更新数据
     * @param temp 温度
     * @param humidity 湿度
     * @param pressure 压力
     */
    void update(float temp, float humidity, float pressure);

}
