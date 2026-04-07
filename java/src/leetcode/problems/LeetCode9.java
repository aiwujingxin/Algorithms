package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:56
 */
public class LeetCode9 {

    public boolean isPalindrome(int x) {
        int r = 0, t = x;
        while (t > 0) {
            r = r * 10 + t % 10;
            t /= 10;
        }
        return r == x;
    }

    class Solution_Best {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) return false;
            int r = 0;
            while (r < x) {
                r = r * 10 + x % 10;
                x /= 10;
            }
            // 偶奇长度
            return r == x || r / 10 == x;
        }
    }
}
