package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 10:09
 */
public class LeetCode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 剪枝逻辑，值相同的树枝，只遍历第一条
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}
