package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 23:26
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n){
            if (val != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
