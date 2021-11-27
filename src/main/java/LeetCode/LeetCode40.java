package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-21 10:45 下午
 */
public class LeetCode40 {

    public static void main(String[] args) {
        LeetCode40 leetCode40 = new LeetCode40();

        System.out.println(leetCode40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }


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

        for (int i = start; i < candidates.length; i++) {
            //本层不能有重复的数字
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            helper(ans, candidates, target - candidates[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
