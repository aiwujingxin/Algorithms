package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/19 14:22
 */
public class LeetCode581 {

    //https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/2564223/Java-O(n)-solution
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i - 1]);
            }
        }

        if (min > max) {

            return 0;
        }

        int l = 0, r = nums.length - 1;
        while (nums[l] <= min) {
            l++;
        }

        while (nums[r] >= max) {
            r--;
        }

        return r - l + 1;
    }
}


