package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/18 14:49
 */
public class LeetCode179 {

    public String largestNumber(int[] nums) {
        String[] a = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(a, (x, y) -> (y + x).compareTo(x + y));
        StringBuilder sb = new StringBuilder();
        for (String s : a) {
            if (sb.isEmpty() && s.equals("0")) {
                continue;
            }
            sb.append(s);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
