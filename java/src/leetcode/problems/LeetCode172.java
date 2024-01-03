package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/24 22:23
 */
public class LeetCode172 {

    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n = n / 5;
            ans += n;
        }
        return ans;
    }
}
