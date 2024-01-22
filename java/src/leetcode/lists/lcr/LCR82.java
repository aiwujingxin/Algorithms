package leetcode.lists.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/28 21:15
 */
public class LCR82 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, res, new ArrayList<>(), target);
        return res;
    }

    private void backtrack(int[] candidates, int index, List<List<Integer>> res, List<Integer> list, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < candidates.length; i++) {
            if (set.contains(candidates[i])) {
                continue;
            }
            set.add(candidates[i]);
            list.add(candidates[i]);
            backtrack(candidates, i + 1, res, list, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
