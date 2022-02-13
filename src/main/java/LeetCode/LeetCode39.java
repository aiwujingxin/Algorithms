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
        helper(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void helper(List<List<Integer>> ans, int[] candidates, int target, ArrayList<Integer> temp, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            helper(ans, candidates, target - candidates[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
