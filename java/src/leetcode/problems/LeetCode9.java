package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:56
 */
public class LeetCode9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int xx = x;
        int rx = 0;
        while (xx > 0) {
            rx = rx * 10 + xx % 10;
            xx = xx / 10;
        }
        return rx == x;
    }
}
