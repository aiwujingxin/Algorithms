package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 18:10
 */
public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return nums[l] < target ? l + 1 : l;
    }
}
