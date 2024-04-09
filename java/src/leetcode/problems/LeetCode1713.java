package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/26 20:44
 * @see LeetCode300_greedy
 */
public class LeetCode1713 {

    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                list.add(map.get(j));
            }
        }
        return n - lengthOfLIS(list);
    }

    public int lengthOfLIS(List<Integer> nums) {
        int[] dp = new int[nums.size()];
        int len = 0;
        for (int num : nums) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r >> 1;
                if (dp[mid] < num) l = mid + 1;
                else r = mid;
            }
            if (len == r) {
                len++;
            }
            dp[l] = num;
        }
        return len;
    }
}
