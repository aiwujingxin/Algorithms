package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/7 10:56
 */
public class LeetCode1524 {

    public int numOfSubarrays(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int mod = 1000000007;
        int presum = 0;
        long sum0 = 1;
        long sum1 = 0;
        long res = 0;
        for (int num : arr) {
            presum += num;
            if (presum % 2 == 1) {
                res = res + sum0;
                sum1++;
            } else {
                res = res + sum1;
                sum0++;
            }
        }
        return (int) (res % mod);
    }
}
