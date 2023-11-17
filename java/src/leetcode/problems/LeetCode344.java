package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 22:28
 */
public class LeetCode344 {

    public void reverseString(char[] s) {
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
