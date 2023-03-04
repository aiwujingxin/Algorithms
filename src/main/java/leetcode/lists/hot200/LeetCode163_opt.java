package leetcode.lists.hot200;

import java.util.ArrayList;
import java.util.List;

public class LeetCode163_opt {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        for (int num : nums) {
            if (num > lower) {
                ans.add(miss(lower, num - 1));
            }
            if (num == upper) {
                return ans;
            }
            lower = num + 1;
        }
        if (lower <= upper) {
            ans.add(miss(lower, upper));
        }
        return ans;
    }

    public static String miss(int lower, int upper) {
        String left = String.valueOf(lower);
        String right = "";
        if (lower < upper) {
            right = "->" + upper;
        }
        return left + right;
    }
}
