package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/22 16:15
 */
public class LeetCode525 {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            if (map.containsKey(s[i])) {
                max = Math.max(max, i - map.get(s[i]));
            } else {
                map.put(s[i], i);
            }
        }
        return max;
    }
}
