package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 23:26
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (val != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
