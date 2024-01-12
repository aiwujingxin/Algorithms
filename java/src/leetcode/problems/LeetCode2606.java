package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/12 11:11
 */
public class LeetCode2606 {

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), vals[i]);
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                nums[i] = map.get(s.charAt(i));
            } else {
                nums[i] = s.charAt(i) - 'a' + 1;
            }
        }
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return Math.max(max, 0);
    }
}
