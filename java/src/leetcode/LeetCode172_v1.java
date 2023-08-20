package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/15 19:02
 */
public class LeetCode172_v1 {

    //study
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }
}
