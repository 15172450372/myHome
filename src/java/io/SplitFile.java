package java.io;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @Author: zhouwei
 * @Description: 文件分割
 * @Date: 2019/8/8 16:38
 * @Version: 1.0
 **/
public class SplitFile {

    private File srcFile;  //源文件
    private String destDir;  //目的文件存放路径
    private List<String> destPaths;  //文件存放路径
    private int blockSize;  //块大小
    private int size;  //块数

    public SplitFile(String srcPath, String destDir, int blockSize) {
        this.srcFile = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<>();
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        //计算块数
        long length = this.srcFile.length();
        this.size = (int) Math.ceil(length/this.blockSize);
        //计算文件存放路径
        for (int i=0; i<size; i++) {
            this.destPaths.add(this.destDir + "/" + i + "-" + this.srcFile.getName());
        }
    }

    /**
     * 切割
     */
    public void split() throws IOException {
        //计算起始位置及大小
        long length = this.srcFile.length();
        int beginPos = 0;
        int actualSize = (int) (blockSize > length ? length : blockSize);
        for (int i=0; i<size; i++) {
            beginPos = i*blockSize;
            if (i == size-1) {
                //最后一块
                actualSize = (int)length;
            } else {
                actualSize = blockSize;
                length -= actualSize;
            }
            //System.out.println(beginPos + "->" + beginPos+length);
            actualSplit(i,beginPos,actualSize);
        }

    }

    /**
     * 实际分割
     * @param i 第几块
     * @param beginPos 切割起始位置
     * @param actualSize 切割大小
     * @throws IOException
     */
    public void actualSplit(int i, int beginPos, int actualSize) throws IOException {

        RandomAccessFile raf = new RandomAccessFile(this.srcFile,"r");
        RandomAccessFile raf1 = new RandomAccessFile(this.destPaths.get(i), "rw");

        //确定起始位置
        raf.seek(beginPos);

        //分段读取
        byte[] buff = new byte[1024];
        int len = -1;
        while ((len=raf.read(buff)) != -1) {
            if (actualSize > len) {
                raf1.write(buff,0,len);
                actualSize -= len;
            } else {
                raf1.write(buff,0,actualSize);
                break;
            }
        }
        raf1.close();
        raf.close();
    }

    /**
     * 合并
     * @param destPath
     */
    public void mergeFile(String destPath) throws IOException {

        //输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath, true));
        Vector<InputStream> vector = new Vector<>();
        SequenceInputStream sis = null;
        for (int i=0; i<destPaths.size(); i++) {
            vector.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
        }
        sis = new SequenceInputStream(vector.elements());
        //输入流
        byte[] bytes = new byte[1024];
        while (sis.read(bytes) != -1) {
            String string = new String(bytes);
            os.write(bytes);
        }
        os.flush();
        sis.close();
        os.close();
    }

    public static void main(String[] args) throws IOException {
        String srcPath = "src/javabasic/io/file/1.jpg";
        String destDir = "src/javabasic/io/file/dest";
        SplitFile splitFile = new SplitFile(srcPath,destDir,1024);
        splitFile.split();

        splitFile.mergeFile("src/javabasic/io/file/aaa.jpg");
    }

}
