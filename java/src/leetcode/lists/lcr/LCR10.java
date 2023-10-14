package leetcode.lists.lcr;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 13:19
 */
public class LCR10 {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int cnt = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                cnt += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
