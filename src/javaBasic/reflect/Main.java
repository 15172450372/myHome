package javaBasic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: zhouwei
 * @Description: java反射
 * @Date: 2019/7/17 15:46
 * @Version: 1.0
 **/
public class Main {

    public static void main(String[] args) throws Exception  {
        //getClazz();
        //getMethod();
        setUpOrgetField();
    }

    /**
     * 反射获取类
     * @throws ClassNotFoundException
     */
    static void getClazz() throws ClassNotFoundException {
        //第一种：通过获取类的静态成员变量class得到
        Class<ReflectDemo> class1 = ReflectDemo.class;
        System.out.println(class1.getName());

        //第二种：通过一个类的对象的getClass()方法获得
        ReflectDemo reflectDemo = new ReflectDemo();
        Class<ReflectDemo> class2 = (Class<ReflectDemo>) reflectDemo.getClass();
        System.out.println(class2.getName());

        //第三种：通过一个类的全量限定名获得
        Class<ReflectDemo> class3 = (Class<ReflectDemo>) Class.forName("javaBasic.reflect.ReflectDemo");
        System.out.println(class3.getName());
    }

    /**
     * 获取类的属性
     * getFields返回的是申明为public的属性，包括父类中定义，
     * getDeclaredFields返回的是指定类定义的所有定义的属性，不包括父类的。
     */
    static void getField() {
        Class<ReflectDemo> classType = ReflectDemo.class;

        //使用getFields()获取属性
        Field[] fields = classType.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();

        //使用getDeclaredFields()获取属性
        fields = classType.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    /**
     * 获取类的方法
     * getMethods返回的是申明为public的方法，包括父类中定义，
     * getDeclaredMethods返回的是指定类定义的所有定义的方法，不包括父类的。
     */
    static void getMethod() {
        Class<ReflectDemo> classType = ReflectDemo.class;

        //使用getMethods()获取类的方法
        Method[] methods = classType.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();

        //使用getDeclaredMethods()获取类的方法
        methods = classType.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /**
     * 获取类的构造器
     * getConstructors返回的是申明为public的构造器，包括父类中定义，
     * getDeclaredConstructors返回的是指定类定义的所有定义的构造器，不包括父类的。
     */
    static void getConstructor() {
        Class<ReflectDemo> classType = ReflectDemo.class;

        //使用getConstructors()获取类的构造器方法
        Constructor<?>[] constructors = classType.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println();

        //getDeclaredConstructors()获取类的构造器方法
        constructors = classType.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }

    /**
     * 新建类的实例
     */
    static void newClass() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1、调用类的Class对象的newInstance()方法，该方法会调用对象的默认构造器，如果没有默认构造器，会调用失败
        Class<ReflectDemo> classType = ReflectDemo.class;

        ReflectDemo newInstance = classType.newInstance();
        System.out.println(newInstance);

        System.out.println();

        //2、调用默认Constructor对象的newInstance()方法
        Constructor<ReflectDemo> constructor = classType.getConstructor();
        ReflectDemo newInstance2 = constructor.newInstance();
        System.out.println(newInstance2);

        System.out.println();

        //3、调用带参数Construtctor对象的newInstance()方法
        Constructor<ReflectDemo> declaredConstructor = classType.getDeclaredConstructor(int.class, String.class, int.class, String.class, String.class);
        ReflectDemo newInstance3 = declaredConstructor.newInstance(1,"123",20,"123456789","123456789@qq.com");

        System.out.println(newInstance3);
    }

    /**
     * 调用类的方法
     */
    static void transferMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<ReflectDemo> classType = ReflectDemo.class;
        ReflectDemo newInstance = classType.newInstance();
        Method declaredMethod = classType.getDeclaredMethod("setName", String.class);
        declaredMethod.invoke(newInstance, "123");
    }

    /**
     * 设置/获取类的属性
     */
    static void setUpOrgetField() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<ReflectDemo> classType = ReflectDemo.class;
        ReflectDemo newInstance = classType.newInstance();
        Field field = classType.getDeclaredField("tell");
        field.set(newInstance, "123");
        Object value = field.get(newInstance);
        System.out.println(value);
    }
}
