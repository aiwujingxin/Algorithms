package offer;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-11-26 12:57 上午
 */
public class Offer61 {

    public static void main(String[] args) {
        System.out.println(new Offer61().isStraight(new int[]{0, 0, 8, 5, 4}));
        System.out.println(new Offer61().isStraight(new int[]{0, 0, 2, 2, 5}));
    }

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int num : nums) {

            if (num == 0) {
                count++;
            }
        }
        int diff = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && nums[i] != 0) {
                return false;
            }
            if (nums[i] - nums[i - 1] > 1 && nums[i - 1] != 0) {
                diff = diff + nums[i] - nums[i - 1] - 1;
            }
        }
        return diff <= count;
    }
}
