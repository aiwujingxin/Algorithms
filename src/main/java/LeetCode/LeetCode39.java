package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-21 1:17 下午
 */
public class LeetCode39 {

    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();
        System.out.println(leetCode39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        helper(res, candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void helper(ArrayList<List<Integer>> res, int[] candidates, int index, int target,
            ArrayList<Integer> combine) {

        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        helper(res, candidates, index + 1, target, combine);
        // 选择当前数
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            helper(res, candidates, index, target - candidates[index], combine);
            combine.remove(combine.size() - 1);
        }
    }
}
