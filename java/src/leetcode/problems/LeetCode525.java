package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 22:49
 */
public class LeetCode525 {

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int[] presum = new int[nums.length];
        presum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        System.out.println(Arrays.toString(presum));
        map.put(0, -1);
        for (int i = 0; i < presum.length; i++) {
            if (map.containsKey(presum[i])) {
                max = Math.max(max, i - map.get(presum[i]));
            }
            if (!map.containsKey(presum[i])) {
                map.put(presum[i], i);
            }
        }
        return max;
    }
}
