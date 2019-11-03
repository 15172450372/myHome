package pattern.actual.vipCost;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/11/3 下午10:25
 * @Version: 1.0
 **/
public class User {

    private int id;
    private String type;

    public User() {
    }

    public User(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
