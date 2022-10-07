package leetplan.algorithm.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 18:17
 */
public class LeetCode977 {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int pos = n - 1;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                ans[pos] = nums[left] * nums[left];
                ++left;
            } else {
                ans[pos] = nums[right] * nums[right];
                --right;
            }
            --pos;
        }
        return ans;
    }
}
