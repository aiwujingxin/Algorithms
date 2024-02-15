package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/9 13:20
 */
public class LeetCode1726 {

    public int tupleSameProduct(int[] nums) {
        int res = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long t = (long) nums[i] * nums[j];
                map.put(t, map.getOrDefault(t, 0) + 1);

            }
        }
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res = (entry.getValue() - 1) * entry.getValue() * 4;
            }
        }
        return res;
    }
}
