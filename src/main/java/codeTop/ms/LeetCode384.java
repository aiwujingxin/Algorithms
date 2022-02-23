package codeTop.ms;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jingxinwu
 * @date 2022-02-23 6:44 PM
 */
public class LeetCode384 {

    private Random r = new Random();
    private int[] nums;
    private int[] orign;

    public LeetCode384(int[] nums) {
        this.nums = nums;
        this.orign = Arrays.copyOf(nums, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return orign;
    }

    /**
     * Returns a random shuffling of the array.
     *
     * https://www.youtube.com/watch?v=8DHwp1Rtp0Q ,4分10秒
     *
     *
     */

    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int index = r.nextInt(nums.length - i);
            int select = nums[index];
            int temp = nums[i];
            nums[i] = select;
            nums[index] = temp;
        }
        return nums;
    }
}
