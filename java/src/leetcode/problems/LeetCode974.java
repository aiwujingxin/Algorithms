package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/22 20:30
 * @description 根据同余定理
 * 注意java负数取模的特性:-5%2=-1
 */
public class LeetCode974 {

    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int sum : s) {
            int mod = (sum % k + k) % k;
            if (map.containsKey(mod)) {
                cnt += map.get(mod);
            }
            map.merge(mod, 1, Integer::sum);
        }
        return cnt;
    }
}
