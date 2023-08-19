package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 21:39
 */
public class LeetCode40_set {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);

        helper(ans, candidates, target, new ArrayList<>(), 0);

        return ans;

    }

    private void helper(List<List<Integer>> ans, int[] candidates, int target, ArrayList<Integer> temp, int start) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        HashSet<Integer> visited = new HashSet<>();

        for (int i = start; i < candidates.length; i++) {
            // 本层不能有重复的数字，visited 去重
            if (visited.contains(candidates[i])) {
                continue;
            }
            visited.add(candidates[i]);
            temp.add(candidates[i]);
            helper(ans, candidates, target - candidates[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
