package leetcode.plan.binarysearch.level2;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/23 15:58
 */
public class LeetCode611_two_point {

    //https://www.jiakaobo.com/leetcode/611.%20Valid%20Triangle%20Number.html

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
