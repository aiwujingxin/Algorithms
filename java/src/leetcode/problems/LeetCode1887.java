package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/28 14:15
 */
public class LeetCode1887 {

    public int reductionOperations(int[] nums) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }
        int cnt = 0;
        int res = 0;
        for (int i = min + 1; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                cnt++;
                res += cnt * bucket[i];
            }
        }
        return res;
    }
}
