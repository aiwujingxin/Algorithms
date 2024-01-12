package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/12 10:53
 */
public class LeetCode1630 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int n = l.length;
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = l[i];
            int end = r[i];
            list.add(check(nums, start, end));
        }
        return list;
    }

    private Boolean check(int[] nums, int start, int end) {
        if (end < start) {
            return false;
        }
        if (end - start <= 2) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        int diff = list.get(1) - list.get(0);
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) != diff) {
                return false;
            }
        }
        return true;
    }
}
