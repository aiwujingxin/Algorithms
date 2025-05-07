package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:56
 */
public class LeetCode9 {

    public boolean isPalindrome(int x) {
        int rx = 0, ox = x;
        while (x > 0) {
            rx = rx * 10 + x % 10;
            x /= 10;
        }
        return rx == ox;
    }
}
