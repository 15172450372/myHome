import java.util.HashMap;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/10/26 下午4:52
 * @Version: 1.0
 **/
public class Student implements Comparable {

    //示例1：
    private static int grade=5;
    private static int number=7;
    public static Student student = new Student();
    public Student() {
        grade++;
        number++;
        System.out.println("构造方法+getGrade1="+grade);
        System.out.println("构造方法+getNumber1="+number);
    }

    public static Student getInstance(){
        System.out.println("111111111111");
        System.out.println("获取实例grade="+grade);
        System.out.println("获取实例number="+number);
        System.out.println("222222222222");
        return student;
    }


    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.put("c", 3);
        //Set<Map.Entry<String, Integer>> eSet = hashMap.entrySet();
        //for(Map.Entry<String, Integer> entry : eSet) {
        //    System.out.println(entry.getKey() + ": " + entry.getValue());
        //}
        hashMap.forEach((k,v)->{
            System.out.println(k + "->" + v);
        });
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
	//输出结果：
    //        构造方法+getGrade1=6
    //        构造方法+getNumber1=8
    //        x1=6
    //        y1=8
