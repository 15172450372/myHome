package algorithm.dataStructure;


public interface MyQueue {

    void qInit(int capacity);

    int[] qpush(int element) throws Exception;

    int[] qPop();

    boolean qEmpty();

    boolean qFull();

}
