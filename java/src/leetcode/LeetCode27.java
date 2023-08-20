package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/1 10:58
 */
public class LeetCode27 {

    int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
