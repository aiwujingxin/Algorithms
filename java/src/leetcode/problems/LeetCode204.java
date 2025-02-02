package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 16:05
 * @description 埃氏筛 O(nloglogn)
 */
public class LeetCode204 {

    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] dp = new boolean[n];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!dp[i]) {
                cnt++;
                for (int j = 2; j * i < n; j++) {
                    dp[j * i] = true;
                }
            }
        }
        return cnt;
    }
}
