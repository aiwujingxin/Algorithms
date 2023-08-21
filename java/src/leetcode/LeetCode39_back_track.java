package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-21 1:17 下午
 */
public class LeetCode39_back_track {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        backtrack(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(List<List<Integer>> ans, int[] candidates, int target, ArrayList<Integer> temp, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        //for (int i = 0; i < candidates.length; i++) 会重复
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(ans, candidates, target - candidates[i], temp, i); // fix i+1
            temp.remove(temp.size() - 1);
        }
    }
}
