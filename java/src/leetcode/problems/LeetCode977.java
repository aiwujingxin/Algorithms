package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 18:17
 */
public class LeetCode977 {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int index = n - 1;
        int[] ans = new int[n];
        while (left <= right)
            ans[index--] = Math.abs(nums[left]) > Math.abs(nums[right]) ?
                    nums[left] * nums[left++] :
                    nums[right] * nums[right--];
        return ans;
    }
}
