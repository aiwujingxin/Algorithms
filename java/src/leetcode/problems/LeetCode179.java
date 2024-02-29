package leetcode.problems;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/28 11:43
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

        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            if (sb.isEmpty() && Objects.equals(string, "0")) {
                continue;
            }
            sb.append(string);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
