package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/16 00:16
 */
public class LeetCode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        backtrack(0, res, candidates, target, new ArrayList<>());
        return res;
    }

    private void backtrack(int index, List<List<Integer>> ans, int[] candidates, int target, List<Integer> temp) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(i, ans, candidates, target - candidates[i], temp);
            temp.remove(temp.size() - 1);
        }
    }
}
