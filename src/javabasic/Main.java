package javabasic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/7/17 16:18
 * @Version: 1.0
 **/
public class Main {

    public static void main(String[] args) {

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(null, 1);
        Object o = objectObjectHashMap.get(123);
        System.out.println(objectObjectHashMap.size());
    }
}
