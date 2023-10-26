package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/26 10:33
 * @see LeetCode26
 */
public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
