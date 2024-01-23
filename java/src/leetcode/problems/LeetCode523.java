package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/21 21:27
 * @description 同余定理
 */
public class LeetCode523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int mod = presum[i] % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }
}
