package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/27 14:58
 */
public class LeetCode401 {

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn == 0) {
            List<String> list = new ArrayList<>();
            list.add("0:00");
            return list;
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= turnedOn; i++) {
            List<Integer> hours = new ArrayList<>();
            backtrack(0, i, new int[]{1, 2, 4, 8}, hours, 0, 12);
            List<Integer> minutes = new ArrayList<>();
            backtrack(0, turnedOn - i, new int[]{1, 2, 4, 8, 16, 32}, minutes, 0, 60);
            for (Integer h : hours) {
                for (Integer m : minutes) {
                    if (h == 0 && m == 0) {
                        continue;
                    }
                    res.add(h + ":" + (m <= 9 ? "0" + m : m));
                }
            }
        }
        return res;
    }

    private void backtrack(int start, int maxCnt, int[] nums, List<Integer> res, int sum, int max) {
        if (sum >= max) {
            return;
        }
        if (maxCnt == 0) {
            res.add(sum);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            sum += nums[i];
            maxCnt--;
            backtrack(i + 1, maxCnt, nums, res, sum, max);
            sum -= nums[i];
            maxCnt++;
        }
    }
}
