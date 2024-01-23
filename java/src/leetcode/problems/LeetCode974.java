package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/22 20:30
 */
public class LeetCode974 {

    public int subarraysDivByK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int cnt = 0;
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int sum : presum) {
            // 注意java负数取模的特性:-5%2=-1
            int mod = (sum % k + k) % k;
            // 根据同余定理
            if (map.containsKey(mod)) {
                cnt += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return cnt;
    }
}
