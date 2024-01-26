package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/26 13:03
 */
public class LeetCode1390 {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int factor_cnt = 0, factor_sum = 0;
            for (int i = 1; i * i <= num; ++i) {
                if (num % i == 0) {
                    factor_cnt++;
                    factor_sum += i;
                    if (i * i != num) {
                        factor_cnt++;
                        factor_sum += num / i;
                    }
                }
            }
            if (factor_cnt == 4) {
                ans += factor_sum;
            }
        }
        return ans;
    }
}

