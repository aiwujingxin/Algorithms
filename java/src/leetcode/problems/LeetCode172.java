package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/24 22:23
 */
public class LeetCode172 {

    public int trailingZeroes(int n) {
        int ans = 0;
        while (n >= 5) {
            ans += n / 5;
            n = n / 5;
        }
        return ans;
    }
}
