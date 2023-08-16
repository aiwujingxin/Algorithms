package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/24 12:42
 */
public class LeetCode2090 {

    public int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        int l = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            if (i < 2 * k) {
                sum += nums[i];
            } else {
                sum += nums[i];
                res[i - k] = (int) (sum / (2 * k + 1));
                sum -= nums[l++];
            }
        }
        return res;
    }
}
