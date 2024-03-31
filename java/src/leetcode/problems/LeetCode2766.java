package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/30 13:28
 */
public class LeetCode2766 {

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        int n = moveFrom.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < n; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        return new ArrayList<>(set);
    }
}
