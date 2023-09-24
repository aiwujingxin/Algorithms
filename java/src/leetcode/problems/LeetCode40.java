package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 21:39
 */
public class LeetCode40 {
    /*
     * [10,1,2,7,6,1,5]
     * 8
     *
     * 首先sort 是为了防止 [1,7][7,1]这样的重复结果
     *
     * */
    /*
     * [10,1,2,7,6,1,5]
     * 8
     *
     * sort 完了之后 加锁 可以防止 [1,7][1`,7]这样的重复结果, 1` ～ 1`` 等重复的数字，都会在当前层的set控制住，不会向下递归，
     * 所以结果里不会出现[1, XXXXX], [1`,XXXX]的情况
     *
     * */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        backtrack(ans, candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] candidates, int target, ArrayList<Integer> temp, int start) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        HashSet<Integer> visited = new HashSet<>();

        for (int i = start; i < candidates.length; i++) {
            if (visited.contains(candidates[i])) {
                continue;
            }
            visited.add(candidates[i]);
            temp.add(candidates[i]);
            backtrack(ans, candidates, target - candidates[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
