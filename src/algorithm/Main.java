package algorithm;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/20 19:37
 * @Version: 1.0
 **/
public class Main {

    public static void main(String[] args) {
        System.out.println(strStr("a","a"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int lengthA = haystack.length();
        int lengthB = needle.length();
        if (lengthB > lengthA) {
            return -1;
        }
        for (int i=0; i<lengthA; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                String substring;
                if (i+lengthB <= lengthA) {
                    substring = haystack.substring(i, i+lengthB);
                } else {
                    return -1;
                }
                if (substring.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }


}

