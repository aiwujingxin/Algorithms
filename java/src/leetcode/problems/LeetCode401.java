package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/27 14:58
 */
public class LeetCode401 {

    private static final int[] HOURS = {1, 2, 4, 8};
    private static final int[] MINUTES = {1, 2, 4, 8, 16, 32};


    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn == 0) return Collections.singletonList("0:00");
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= turnedOn; i++) {
            List<Integer> hours = new ArrayList<>();
            backtrack(0, i, HOURS, hours, 0, 12);
            List<Integer> minutes = new ArrayList<>();
            backtrack(0, turnedOn - i, MINUTES, minutes, 0, 60);
            for (int h : hours) {
                for (int m : minutes) {
                    if (h == 0 && m == 0) continue;
                    res.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }
        return res;
    }

    private void backtrack(int start, int count, int[] nums, List<Integer> res, int sum, int max) {
        if (sum >= max) return;
        if (count == 0) {
            res.add(sum);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            backtrack(i + 1, count - 1, nums, res, sum + nums[i], max);
        }
    }
}
