package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/12 17:37
 */
public class LeetCode53_Kadane {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        while (i < nums.length) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum <= 0) {
                sum = 0;
            }
            i++;
        }
        return maxSum;
    }
}
