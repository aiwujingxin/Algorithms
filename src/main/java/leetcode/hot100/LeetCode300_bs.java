package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 02:03
 */
public class LeetCode300_bs {

    //https://leetcode.com/problems/longest-increasing-subsequence/discuss/2485423/EASY-to-understand-ALL-JAVA-solutions

    public int lengthOfLIS(int[] nums) {
        int[] temp = new int[nums.length];
        int size = 0;
        temp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp[size]) {
                // arr[i] > the last element of temp array
                temp[++size] = nums[i];
            } else {
                // replacement step
                int ind = lower_bound(temp, 0, size, nums[i]);
                temp[ind] = nums[i];
            }
        }
        return size + 1;
    }

    public int lower_bound(int[] nums, int i, int j, int x) {
        while (i < j) {
            int m = i + (j - i) / 2;
            if (nums[m] < x) {
                i = m + 1;
            } else {
                j = m;
            }
        }
        return i;
    }
}
