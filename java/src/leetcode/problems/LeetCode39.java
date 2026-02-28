package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 21:43
 */
public class LeetCode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        bk(res, candidates, 0, 0, target, new ArrayList<>());
        return res;
    }

    public void bk(List<List<Integer>> res, int[] c, int start, int sum, int target, List<Integer> list) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < c.length; i++) {
            list.add(c[i]);
            bk(res, c, i, sum + c[i], target, list);
            list.removeLast();
        }
    }
}
