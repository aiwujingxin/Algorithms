package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 22:26
 */
public class LeetCode922 {

    public int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 1;
        while (i < nums.length) {
            if (nums[i] % 2 == 0) { // 寻找偶数下标中最左边的奇数
                i += 2;
            } else if (nums[j] % 2 == 1) { // 寻找奇数下标中最左边的偶数
                j += 2;
            } else {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i += 2;
                j += 2;
            }
        }
        return nums;
    }
}
