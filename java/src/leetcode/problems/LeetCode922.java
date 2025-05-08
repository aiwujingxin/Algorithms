package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 22:26
 */
public class LeetCode922 {

    public int[] sortArrayByParityII(int[] nums) {
        int even = 0, odd = 1;
        while (even < nums.length && odd < nums.length) {
            if (nums[even] % 2 == 0) {
                even += 2; // even 找错误的偶数位
            } else if (nums[odd] % 2 == 1) {
                odd += 2;// odd 找错误的奇数位
            } else {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                even += 2;
                odd += 2;
            }
        }
        return nums;
    }
}
