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
        backtrack(candidates, 0, res, new ArrayList<>(), target);
        return res;
    }

    // 隐式处理：`for` 循环的下一次迭代 `i++` 自动处理了“不选当前 `i`，而选下一个”的情况。
    private void backtrack(int[] candidates, int start, List<List<Integer>> res, List<Integer> list, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) continue;
            list.add(candidates[i]);
            backtrack(candidates, i, res, list, target - candidates[i]);
            list.removeLast();
        }
    }
}
