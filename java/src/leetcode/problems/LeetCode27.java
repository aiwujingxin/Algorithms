package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 17:38
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (val != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
