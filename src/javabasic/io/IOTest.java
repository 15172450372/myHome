package javabasic.io;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/7 19:20
 * @Version: 1.0
 **/
public class IOTest {

    public static void main(String[] args) throws Exception {

        //String path = "C:/Users/13701/IdeaProjects/myHome/src/javabasic/io/file/1.txt";
        String srcPath = "src/javabasic/io/file/1.txt";
        String destPath = "src/javabasic/io/file/dest.txt";

        //-----字节流
        //encodeTest();
        //readFile(srcPath);
        //readFileWithBuff(srcPath);
        //writeFile(destPath);
        //copyFile("src/javabasic/io/1.txt","src/javabasic/io/file/2.txt");
        //copyFile("src/javabasic/io/1.jpg","src/javabasic/io/file/copy.jpg");

        //-----字符流
        //readFile2(srcPath);
        //writeFile2(destPath);
        //copyFile("src/javabasic/io/2.txt","src/javabasic/io/file/3.txt");

        //字节数组流
        //byte[] bytes = file2ByteArray("src/javabasic/io/file/1.jpg");
        //System.out.println(bytes.length);
        //byteArray2File(bytes,"src/javabasic/io/file/2.jpg");

        //convert();
        convert2();
        //dataStreamTest();
        //objectStreamTest();
        //objectWriteAndRead();

        //printStreamTest();
    }

    /**
     * 乱码测试
     * @throws UnsupportedEncodingException
     */
    public static void encodeTest() throws UnsupportedEncodingException {

        //编码(字符串->字节数组)，默认使用工程的字符集
        String msg = "JAVA字符串a";
        byte[] bytes = msg.getBytes();

        //解码(字节数组->字符串)
        String string = new String(bytes, 0, bytes.length, "utf-8");
        System.out.println(string);

        //乱码1：字符集不统一
        String string2 = new String(bytes, 0, bytes.length, "GBK");
        System.out.println(string2);

        //乱码1：字节数不一
        String string3 = new String(bytes, 0, bytes.length - 2, StandardCharsets.UTF_8);
        System.out.println(string3);
    }

    //-----------------------------------字节流----------------------------------------------

    /**
     * 文件读取,逐个字节读取
     * 1.确定数据源
     * 2.选择数据流
     * 3.操作（读/写）数据
     * 4.释放资源
     */
    public static void readFile(String path) {

        //1.确定数据源
        File file = new File(path);
        InputStream inputStream = null;
        try {
            //2.获取数据流
            inputStream = new FileInputStream(file);
            //3.操作数据
            //int char1 = inputStream.read(); //读取一个字节
            //int char2 = inputStream.read();
            //int char3 = inputStream.read();
            //int char4 = inputStream.read();
            //System.out.println((char)char1);
            //System.out.println((char)char2);
            //System.out.println((char)char3);
            //System.out.println(char4);  //文件的末尾放回-1
            int temp;
            while ((temp = inputStream.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件读取,分块读取
     */
    public static void readFileWithBuff() {

        //1.确定数据源
        //String path = "C:/Users/13701/IdeaProjects/myHome/src/javabasic/io/1.txt";
        String path = "src/javabasic/io/2.txt";
        File file = new File(path);
        InputStream inputStream = null;
        try {
            //2.获取数据流
            inputStream = new FileInputStream(file);
            //3.读取数据
            byte[] buff = new byte[1024];
            int len = -1; //接收长度
            while ((len = inputStream.read(buff)) != -1) {
                String s = new String(buff, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 写文件
     */
    public static void writeFile() {

        //1.创建源（文件不存在会自动创建）
        File destFile = new File("src/javabasic/io/dest.txt");

        //2.选择流
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(destFile,false);
            //3.操作流
            String msg = "write file!";
            byte[] bytes = msg.getBytes();
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件拷贝
     */
    public static void copyFile(String src, String dest) {

        //1.确定源
        File srcFile = new File(src);
        File destFile = new File(dest);
        //2.选择流
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(destFile);
            //3.操作流
            byte[] bytes = new byte[64];
            while (inputStream.read(bytes) != -1) {
                outputStream.write(bytes);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源,分别关闭，先打开后关闭
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //-----------------------------------字符流----------------------------------------------

    public static void readFile2(String path) {
        //1.确定数据源
        File file = new File(path);
        //2.选择流
        Reader reader = null;
        try {
            reader = new FileReader(file);
            //3.操作数据流
            int temp;
            while ((temp = reader.read()) != -1) {
                System.out.println((char)temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void writeFile2(String path) {

        //1.创建源（文件不存在会自动创建）
        File destFile = new File(path);

        //2.选择流
        Writer writer = null;
        try {
            writer = new FileWriter(destFile,false);
            //3.操作流
            String msg = "write file!";
            writer.write(msg);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void copyFile2(String src, String dest) {

        //1.确定源
        File srcFile = new File(src);
        File destFile = new File(dest);
        //2.选择流
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(srcFile);
            writer = new FileWriter(destFile);
            //3.操作流
            char[] buff = new char[1024];
            while (reader.read(buff) != -1) {
                writer.write(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源,分别关闭，先打开后关闭
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //-----------------------------------字节数组流----------------------------------------------

    /**
     * 图片->字节数组
     * 1>图片到程序：FileInputStream
     * 2>程序到字节数组：ByteArrayOutputStream
     * @param filePath
     * @return
     */
    public static byte[] file2ByteArray(String filePath) {
        //1.确定数据源
        String path = "src/javabasic/io/1.jpg";
        File file = new File(path);
        InputStream inputStream = null;
        ByteArrayOutputStream baos;
        try {
            //2.获取数据流
            inputStream = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
            //3.操作数据
            byte[] buff = new byte[1024];
            int len = -1; //接收长度
            while ((len = inputStream.read(buff)) != -1) {
                baos.write(buff,0,len);  //写到字节数组
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 字节数组->图片
     * 1>字节数组到程序：ByteArrayInputStream
     * 2>程序到图片：FileOutputStream
     * @param src
     * @param destPath
     */
    public static void byteArray2File(byte[] src, String destPath) {

        //1.确定数据源
        File file = new File(destPath);
        //2.确定流
        FileOutputStream fos = null;
        ByteArrayInputStream bais;
        try {
            fos = new FileOutputStream(file);
            bais = new ByteArrayInputStream(src);
            //3.操作数据
            byte[] buff = new byte[1024];
            while (bais.read(buff) != -1) {
                fos.write(buff);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //-----------------------------------缓冲流（装饰器模式）----------------------------------------------
    //FileInputStream -> BufferedInputStream
    //FileOutputStream -> BufferedOutputStream
    //...(记得flush)

    //-----------------------------------转换流----------------------------------------------

    /**
     * 字节流->字符流
     * InputStreamReader
     */
    public static void convert() {
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new URL("http://www.baidu.com").openStream(), StandardCharsets.UTF_8));
            String msg;
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void convert2() {
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(
                            new InputStreamReader((System.in)));
            BufferedWriter bufferedWriter =
                    new BufferedWriter(
                            new OutputStreamWriter(System.out));
            String msg;
            while ((msg = bufferedReader.readLine()) != null) {
                if (msg.equalsIgnoreCase("exit")) {
                    break;
                }
                bufferedWriter.write(msg);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    //-----------------------------------数据流----------------------------------------------

    public static void dataStreamTest() throws IOException {

        //写入
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bos));
        dos.writeUTF("世界和平");
        dos.writeBoolean(true);
        dos.writeInt(12);
        dos.writeDouble(1.5);
        dos.flush();
        byte[] datas = bos.toByteArray();

        //读取，读取顺序与写入顺序一致
        ByteArrayInputStream bis = new ByteArrayInputStream(datas);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(bis));
        String s = dis.readUTF();
        boolean b = dis.readBoolean();
        int i = dis.readInt();
        double v = dis.readDouble();
        System.out.println(b);
    }

    //-----------------------------------对象流----------------------------------------------

    static class Student implements Serializable {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return this.name + ":" + this.age;
        }
    }

    /**
     * 对象->流：序列化
     * 流->对象：反序列化
     */
    public static void objectStreamTest() throws IOException, ClassNotFoundException {

        //写入
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(bos));
        oos.writeUTF("世界和平");
        oos.writeBoolean(true);
        oos.writeInt(12);
        oos.writeDouble(1.5);
        oos.writeObject(new Date());
        oos.writeObject(new Student("tom",25));
        oos.flush();
        byte[] datas = bos.toByteArray();

        //读取，读取顺序与写入顺序一致
        ByteArrayInputStream bis = new ByteArrayInputStream(datas);
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(bis));
        String s = ois.readUTF();
        boolean b = ois.readBoolean();
        int i = ois.readInt();
        double v = ois.readDouble();
        Object o = ois.readObject();
        Object o1 = ois.readObject();
        System.out.println(o);
        System.out.println(o1);

    }

    /**
     * Java对象写入文件并读取
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void objectWriteAndRead() throws IOException, ClassNotFoundException {

        FileOutputStream fileOutputStream = new FileOutputStream("src/javabasic/io/file/4.txt");

        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
        oos.writeObject(new Student("tom",25));
        oos.flush();

        FileInputStream fileInputStream = new FileInputStream("src/javabasic/io/file/4.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(o);

    }


    //-----------------------------------打印流----------------------------------------------

    public static void printStreamTest() throws FileNotFoundException {

        //输出到控制台
        PrintStream ps = System.out;
        ps.println("世界和平");
        ps.print(true);

        //输出到文件
        FileOutputStream fos = new FileOutputStream("src/javabasic/io/file/5.txt");
        PrintStream printStream = new PrintStream(new BufferedOutputStream(fos),true);  //自动刷新
        printStream.println("世界和平");
        printStream.print(true);

    }



}