package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/20 10:34
 */
public class LeetCode494_dfs_v2 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1 || Math.abs(target) > Math.abs(sum)) {
            return 0;
        }

        int targetSum = (sum + target) / 2;
        return combinationSum2(nums, targetSum).size();
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return ans;
        }

        helper(ans, candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    private void helper(List<List<Integer>> ans, int[] candidates, int target, ArrayList<Integer> temp, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            // return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            helper(ans, candidates, target - candidates[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
