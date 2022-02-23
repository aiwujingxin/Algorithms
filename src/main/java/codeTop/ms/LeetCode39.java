package codeTop.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-02-16 2:39 PM
 */
public class LeetCode39 {

    /**
     * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     *
     * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
     *
     * 示例1：
     *
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * 示例2：
     *
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     *
     * 输入: candidates = [2], target = 1
     * 输出: []
     **/

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        helper(list, 0, candidates, 0, target, new ArrayList<>());
        return list;
    }

    private void helper(List<List<Integer>> list, int index, int[] candidates, int sum, int target,
            ArrayList<Integer> temp) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            sum = sum + candidates[i];
            temp.add(candidates[i]);
            //fix 传i进去
            helper(list, i, candidates, sum, target, temp);
            sum = sum - candidates[i];
            temp.remove(temp.size() - 1);
        }
    }
}
