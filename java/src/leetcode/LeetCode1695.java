package leetcode;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/31 23:32
 */
public class LeetCode1695 {

    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            int num = nums[right];
            if (!map.containsKey(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                sum += num;
                max = Math.max(max, sum);
                right++;
            } else {
                while (map.containsKey(num)) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                    sum -= nums[left];
                    left++;
                }
            }
        }
        return max;
    }
}
