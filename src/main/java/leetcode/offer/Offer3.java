package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jingxinwu
 * @date 2021-11-19 9:06 下午
 */
public class Offer3 {

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
