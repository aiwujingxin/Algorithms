package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/9 22:39
 */
public class LeetCode239_fast {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        int[] result = new int[len - k + 1];
        int left = 0, right = k - 1, maxIndex = -1, max = Integer.MIN_VALUE;

        while (right < len) {
            //保证最大索引值不会过期
            if (maxIndex >= left) {
                if (nums[right] >= max) {
                    max = nums[right];
                    maxIndex = right;
                }
            } else if (nums[right] >= max - 1) {
                max = nums[right];
                maxIndex = right;
            } else if (nums[left] >= max - 1) {
                max = nums[left];
                maxIndex = left;
            } else {
                max = nums[left];
                for (int i = left + 1; i < left + k; i++) {
                    if (nums[i] >= max) {
                        max = nums[i];
                        maxIndex = i;
                    }
                }
            }
            result[left] = max;
            left++;
            right++;
        }
        return result;
    }
}
