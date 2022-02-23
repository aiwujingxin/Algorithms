package codeTop.ms;

import java.util.HashMap;

/**
 * @author jingxinwu
 * @date 2022-02-16 7:11 PM
 */
public class LeetCode560 {

    public int subarraySum(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);

            if (map.containsKey(sum - k)) {
                res = res + map.get(sum - k);
            }
        }
        return res;
    }

}
