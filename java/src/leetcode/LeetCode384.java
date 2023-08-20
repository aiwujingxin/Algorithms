package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jingxinwu
 * @date 2022-02-23 6:44 PM
 */
public class LeetCode384 {

    private final Random r = new Random();
    private final int[] nums;
    private final int[] orign;

    public LeetCode384(int[] nums) {
        this.nums = nums;
        this.orign = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        return orign;
    }

    /**
     * Returns a random shuffling of the array.
     * <p>
     * <a href="https://www.youtube.com/watch?v=8DHwp1Rtp0Q">video</a> ,4分10秒
     * <p>
     * i = 0  [0 n -1]   1 / n
     * i = 1  [1 n -1]   (n -1) /n *  (1 / n - 1) = 1 / n
     * i = 2  [2 n -3]   (n -1) /n *  (n - 2) /(n - 1) * (1 / n - 2) = 1 / n
     */

    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int index = r.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
        return nums;
    }
}
