package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 02:18
 */
public class LeetCode344 {

    public void reverseString(char[] s) {

        if (s == null || s.length == 0) {
            return;
        }

        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }

    }
}
