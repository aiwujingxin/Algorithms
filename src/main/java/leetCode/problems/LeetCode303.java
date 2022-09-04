package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-18 6:57 PM
 */
public class LeetCode303 {

    int[] sums;

    public LeetCode303(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
