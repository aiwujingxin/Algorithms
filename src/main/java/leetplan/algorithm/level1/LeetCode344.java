package leetplan.algorithm.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/8 22:12
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
