package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/19 18:14
 */
public class LeetCode172 {

    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
