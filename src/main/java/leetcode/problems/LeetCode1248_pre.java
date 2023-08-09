package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/18 12:55
 */
public class LeetCode1248_pre {

    //https://leetcode.cn/problems/count-number-of-nice-subarrays/solution/javaqian-zhui-he-by-laflame-2myf/

    public int numberOfSubarrays(int[] nums, int k) {
        int sum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num % 2 == 0 ? 0 : 1;
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
