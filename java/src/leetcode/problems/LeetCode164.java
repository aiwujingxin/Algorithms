package leetcode.problems;

import basic.algorithm.sort.RedixSort;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/13 21:45
 */
public class LeetCode164 {

    public int maximumGap(int[] nums) {
        new RedixSort().sortArray(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

    public int maximumGap_bucket(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int gap = (int) Math.ceil((double) (max - min) / (len - 1));
        int[] bucketsMin = new int[len - 1];
        int[] bucketsMax = new int[len - 1];
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == max || num == min) {
                continue;
            }
            int bucket = (num - min) / gap;
            bucketsMin[bucket] = Math.min(bucketsMin[bucket], num);
            bucketsMax[bucket] = Math.max(bucketsMax[bucket], num);
        }
        int res = 0;
        int pre = min;
        for (int i = 0; i < len - 1; i++) {
            if (bucketsMin[i] == Integer.MAX_VALUE || bucketsMax[i] == Integer.MAX_VALUE) {
                continue;
            }
            res = Math.max(res, bucketsMin[i] - pre);
            pre = bucketsMax[i];
        }
        res = Math.max(res, max - pre);
        return res;
    }
}
