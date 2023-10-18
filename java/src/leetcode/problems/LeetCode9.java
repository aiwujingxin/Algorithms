package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 14:21
 */
public class LeetCode9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int xx = x;
        int rx = 0;
        while (x > 0) {
            rx = rx * 10 + x % 10;
            x /= 10;
        }
        return rx == xx;
    }
}
