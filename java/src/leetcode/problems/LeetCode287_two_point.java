package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/29 14:02
 */
public class LeetCode287_two_point {

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
