package javabasic;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/7/17 16:18
 * @Version: 1.0
 **/
public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("11.txt");
        boolean exists = file.exists();
        System.out.println(exists);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write("123".getBytes());
        exists = file.exists();
        System.out.println(exists);

    }
}
