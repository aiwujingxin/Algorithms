package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 18:10
 */
public class LeetCode41 {

    public static void main(String[] args) {
        System.out.println(new LeetCode41().firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(new LeetCode41().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
