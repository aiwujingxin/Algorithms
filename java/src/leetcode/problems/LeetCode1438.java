package leetcode.problems;

import knowledge.datastructure.other.impl.DequeMinMax;

import java.util.TreeMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/31 23:15
 */
public class LeetCode1438 {

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int left = 0;
        int right = 0;
        int ret = 0;
        while (right < n) {
            map.merge(nums[right], 1, Integer::sum);
            while (map.lastKey() - map.firstKey() > limit) {
                map.merge(nums[left], -1, Integer::sum);
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }

    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            DequeMinMax c = new DequeMinMax();
            int n = nums.length;
            int l = 0;
            int r = 0;
            int max = 0;
            while (r < n) {
                c.insert(nums[r]);
                while (c.getMax() - c.getMin() > limit) {
                    c.remove(nums[l]);
                    l++;
                }
                max = Math.max(max, r - l + 1);
                r++;
            }
            return max;
        }
    }
}
