package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 11/7/25 16:15
 */
public class LeetCode1239 {

    int max = 0;

    public int maxLength(List<String> arr) {
        List<Integer> nums = new ArrayList<>();
        for (String s : arr) {
            int num = 0;
            for (int j = 0; j < s.length(); j++) {
                num |= 1 << (s.charAt(j) - 'a');
            }
            if (Integer.bitCount(num) == s.length()) nums.add(num);
        }
        backtrack(nums, 0, 0, 0);
        return max;
    }

    public void backtrack(List<Integer> nums, int index, int vis, int len) {
        max = Math.max(max, len);
        for (int i = index; i < nums.size(); i++) {
            if ((vis & nums.get(i)) != 0) {
                continue;
            }
            backtrack(nums, i + 1, vis | nums.get(i), len + Integer.bitCount(nums.get(i)));
        }
    }
}
