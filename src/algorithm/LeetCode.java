package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @Descript:
 * @Author: zhouwei
 * @Date: 19-6-24 下午7:47
 * @Version 1.0
 */
public class LeetCode {

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * LeetCode2：两数相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }

    /**
     * LeetCode3:无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                length = Math.max(length, j-i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return length;
    }

    /**
     * LeetCode5: 最长回文子串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();                  //字符串长度
        int maxlen = 1;                      //最长回文字符串长度
        int start = 0;                       //最长回文字符串起始地址
        for(int i = 0; i < len; i++)         //起始地址
        {
            for(int j = i + 1; j < len; j++) //结束地址
            {
                int tmp1 = i, tmp2 = j;
                //判断是不是回文
                while(tmp1 < tmp2 && s.charAt(tmp1) == s.charAt(tmp2)){
                    tmp1++;
                    tmp2--;
                }
                if(tmp1 <= tmp2 && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, maxlen);
    }

    /**
     * LeetCode9: 回文数
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x%10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber*10 + x%10;
            x/=10;
        }
        return x == revertedNumber || x == revertedNumber/10;
    }




}




