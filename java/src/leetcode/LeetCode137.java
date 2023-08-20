package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jingxinwu
 * @date 2021-07-10 6:20 下午
 */
public class LeetCode137 {

    public int singleNumber(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;

    }

}
