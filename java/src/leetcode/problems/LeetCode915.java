package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/2 10:29
 */
public class LeetCode915 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int lmax = nums[0];
        for (int i = 0; i < n; i++) {
            lmax = Math.max(lmax, nums[i]);
            left[i] = lmax;
        }
        int rmax = nums[n - 1];
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            right[i] = rmax;
            rmax = Math.min(rmax, nums[i]);
        }
        int index = 0;
        while (index < n && left[index] > right[index]) {
            index++;
        }
        return index + 1;
    }
}
