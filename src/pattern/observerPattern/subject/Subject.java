package pattern.observerPattern.subject;

import pattern.observerPattern.display.Observer;

/**
 * 主题（发布者）
 */
public interface Subject {

    /**
     * 注册订阅者
     * @param observer
     */
    void registryObserver(Observer observer);

    /**
     * 移除订阅者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知订阅者
     */
    void notifyObservers();

}
