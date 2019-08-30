package java.reflect;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/7/17 15:45
 * @Version: 1.0
 **/
public class ReflectDemo {

    public int id;
    private String name;
    private int age;
    public String tell;
    public String email;

    public ReflectDemo() {
        super();
    }

    public ReflectDemo(int id, String name, int age, String tell, String email) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.tell = tell;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Demo [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName："+name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
