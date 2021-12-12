package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jingxinwu
 * @date 2021-12-11 11:50 下午
 */
public class LeetCode169 {


    public int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int res = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            if (en.getValue() > nums.length / 2) {
                return en.getKey();

            }

        }
        return -1;

    }
}
