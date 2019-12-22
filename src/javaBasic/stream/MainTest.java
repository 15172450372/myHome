package javaBasic.stream;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Author: zhouwei
 * @Description: jdk 1.8 流操作
 * @Date: 2019/12/19 下午7:21
 * @Version: 1.0
 **/
public class MainTest {

    public static void main(String[] args) throws IOException {
        //start();
        //middle();
        end();
    }

    /**
     * 创建流
     */
    public static void start() throws IOException {

        //1.值创建流
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

        //2.数组创建流
        int[] arr = {1, 2, 3, 4, 5, 6};
        IntStream stream2 = Arrays.stream(arr);

        //3.文件获取流
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\test_stream.txt"));
        //Stream<String> stream3 = bufferedReader.lines();
        //stream3.forEach(System.out::println);

        //4.函数生成流
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2).limit(6); //0 2 4 6 8 16
        Stream<Double> stream5 = Stream.generate(Math::random);

        //5.集合生成流
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream6 = list.stream(); //顺序流
        Stream<String> stream7 = list.parallelStream(); //并行流

    }

    /**
     * 流的中间操作
     */
    public static void middle() {

        //1.筛选与切片
        Stream<Integer> stream = Stream.of(1, 2, 3, 3, 4, 5, 5, 6);
        Stream<Integer> newStream = stream.filter(e -> e > 2) //3,3,4,5,5,6
                .distinct() //3,4,5,6
                .skip(1) //4,5,6
                .limit(2);//4,5
        newStream.forEach(System.out::println);

        //2.映射
        List<String> list = Arrays.asList("a,b,c", "1,2,3");
        list.stream().map(e -> e.replaceAll(",", ""))
                .forEach(System.out::println);
        list.stream().flatMap(e -> {
            String[] split = e.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).forEach(System.out::println);

        //3.排序
        Student s7 = new Student("aa", 10,"male");
        Student s8 = new Student("bb", 20,"female");
        Student s9 = new Student("cc", 30,"male");
        Student s10 = new Student("dd", 40,"female");
        List<Student> studentList1 = Arrays.asList(s7, s8, s9, s10);
        studentList1.stream().sorted((o1,o2) -> {
            if (o1.getName().equals(o2.getName())) {
                return o1.getAge() - o2.getAge();
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }).forEach(System.out::println);

        //4.消费
        Student s11 = new Student("aa", 10,"male");
        Student s12 = new Student("bb", 20,"female");
        List<Student> studentList2 = Arrays.asList(s11,s12);
        studentList2.stream().peek(o -> o.setAge(100))
                .forEach(System.out::println);


    }

    /**
     * 流的结束操作
     */
    public static void end() {

        //1.分组
        Student s1 = new Student("aa", 10,"male");
        Student s2 = new Student("aa", 20,"female");
        Student s3 = new Student("aa", 20,"male");
        Student s4 = new Student("bb", 40,"female");
        Student s5 = new Student("bb", 10,"female");
        Student s6 = new Student("cc", 20,"male");
        List<Student> studentList = Arrays.asList(s1, s2, s3, s4, s5, s6);

        //按年龄 排序并分组
        LinkedHashMap<Integer, List<Student>> collect = studentList.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .collect(groupingBy(Student::getAge, LinkedHashMap::new, Collectors.toList()));

        //多级排序并分组
        LinkedHashMap<Integer, LinkedHashMap<String, List<Student>>> collect1 = studentList.stream()
                .sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getName))
                .collect(groupingBy(Student::getAge, LinkedHashMap::new, groupingBy(Student::getName, LinkedHashMap::new, Collectors.toList())));

        collect1.forEach((k,v) -> System.out.println("Key:" + k + "  Value:" + v));
    }


}
