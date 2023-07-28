package leetcode.lists.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/11 18:32
 */
public class LeetCode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, 0, target, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int index, int sum, int target, List<List<Integer>> res, List<Integer> list) {
        if (target < sum) {
            return;
        }

        if (target == sum) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, i, sum, target, res, list);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
