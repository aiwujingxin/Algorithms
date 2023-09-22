package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 23:38
 */
public class LeetCode204 {

    //study
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (!notPrime[i]) {
                ans += 1;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return ans;
    }

    //线性规划
    //二分查找

}