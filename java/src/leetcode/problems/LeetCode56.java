package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 16:21
 */
public class LeetCode56 {

    public int[][] merge(int[][] nums) {
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] cur : nums) {
            if (res.isEmpty() || cur[0] > res.get(res.size() - 1)[1]) {
                res.add(cur);
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], cur[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
