package javaBasic.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/9 9:32
 * @Version: 1.0
 **/
public class CommonIOUtil {

    public static void main(String[] args) throws IOException {

        //test01();
    }

    public static void test01() throws IOException {

        //获得文件信息
        long sizeOfFile = FileUtils.sizeOf(new File("src/javabasic/io/file/1.jpg"));
        long sizeOfDirectory = FileUtils.sizeOfDirectory(new File("src/javabasic/io/file"));
        Collection<File> files = FileUtils.listFiles(new File("src/javabasic/io/file/dest"), EmptyFileFilter.NOT_EMPTY, null);

        //读文件
        String msg = FileUtils.readFileToString(new File("src/javabasic/io/file/2.txt"), StandardCharsets.UTF_8);
        byte[] bytes = FileUtils.readFileToByteArray(new File("src/javabasic/io/file/2.txt"));
        List<String> strings = FileUtils.readLines(new File("src/javabasic/io/file/2.txt"), StandardCharsets.UTF_8);

        //写文件
        FileUtils.write(new File("src/javabasic/io/file/new.txt"),"dfwefwef",StandardCharsets.UTF_8);
        FileUtils.writeStringToFile(new File("src/javabasic/io/file/2.txt"),"追加文字",StandardCharsets.UTF_8,true);

        //拷贝文件
        FileUtils.copyFile(new File("src/javabasic/io/file/2.txt"),new File("src/javabasic/io/file/22.txt"));
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565325987017&di=ce8861088c6f2432b7ac218193d0cde1&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201805%2F25%2F20180525000607_ufhzx.thumb.700_0.jpg";
        FileUtils.copyURLToFile(new URL(url), new File("src/javabasic/io/file/copy.jpg"));
        String s = IOUtils.toString(new URL("http://www.baidu.com"), StandardCharsets.UTF_8);

    }
    
}
