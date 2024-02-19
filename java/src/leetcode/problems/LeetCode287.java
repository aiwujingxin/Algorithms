package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 00:35
 */
public class LeetCode287 {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        return nums[n - 1];
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    //快慢指针
    public int findDuplicate_point(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        // 相遇
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        // 第二次相遇
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
