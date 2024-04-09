package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 01:29
 */
public class LeetCode540 {

    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == nums[mid ^ 1]) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }
}

