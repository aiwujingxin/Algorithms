package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/22 20:30
 * @see LeetCode560
 */
public class LeetCode874 {

    public int subarraysDivByK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            // 这里要格外注意java负数取模的特性:-5%2=-1
            int mod = (sum % k + k) % k;
            // 根据同余定理:sum[j]%k==sum[i-1]%k时,sum[i,j]%k==0
            if (map.containsKey(mod)) {
                cnt += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return cnt;
    }
}
