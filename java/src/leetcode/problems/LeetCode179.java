package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/18 14:49
 */
public class LeetCode179 {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo((o1 + o2)));
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            if (sb.isEmpty() && Objects.equals(s, "0")) {
                continue;
            }
            sb.append(s);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
