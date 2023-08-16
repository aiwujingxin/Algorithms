package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/23 12:59
 */
public class LeetCode719_twopoint {
    //https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/1024240/Java-Simple-Binary-Search-wExplanation
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int minDist = 0;
        int maxDist = nums[nums.length - 1] - nums[0];
        while (minDist <= maxDist) {
            int midDist = minDist + (maxDist - minDist) / 2;
            int left = 0;
            int right = 0;
            int count = 0;
            while (right < nums.length) {
                if (nums[right] - nums[left] > midDist) {
                    left++;
                } else {
                    count += right - left;
                    right++;
                }
            }
            if (count >= k) {
                maxDist = midDist - 1;
            } else {
                minDist = midDist + 1;
            }
        }
        return minDist;
    }
}

