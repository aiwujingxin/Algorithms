package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/1 17:13
 */
public class LeetCode153 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
