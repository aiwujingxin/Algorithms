package leetplan.algorithm.level1;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 21:41
 */
public class LeetCode283 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 0, 6, 9, 12};
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        //fix case
        int[] nums2 = new int[]{2, 1};
        //fix case
        int[] nums3 = new int[]{0, 0, 1};
        new LeetCode283().moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int cur = 0;
        int count = 0;
        while (cur < nums.length - count) {

            while (cur < nums.length - count && nums[cur] != 0) {
                cur++;
            }

            if (cur == nums.length) {
                break;
            }

            int t = cur;
            while (t + 1 <= nums.length - 1 - count) {
                nums[t] = nums[t + 1];
                t++;
            }
            nums[t] = 0;
            count++;
        }
    }
}
