package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/6 17:33
 */
public class LeetCode2762 {

    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0;
        long res = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            //收缩
            while (!map.isEmpty() && map.lastKey() - map.firstKey() > 2) {
                if (map.get(nums[left]) == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], map.get(nums[left]) - 1);
                }
                left++;
            }
            res += right - left + 1;//加上每个结尾的不间断子数组的个数
            right++;
        }
        return res;
    }
}
