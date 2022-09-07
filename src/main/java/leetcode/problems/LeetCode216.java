package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-08-18 12:34 上午
 */
public class LeetCode216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, k, new ArrayList<>(), n, res);
        return res;
    }

    public void helper(int begin, int k, ArrayList<Integer> temp, int target, List<List<Integer>> res) {
        // 1.结束条件
        if (target == 0 && temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 2.选择列表
        for (int i = begin; i <= 9; i++) {
            // 大剪枝
            if (target - i < 0) {
                return;
            }
            // 选择
            temp.add(i);
            // 递归
            helper(i + 1, k, temp, target - i, res);
            // 撤销选择
            temp.remove(temp.size() - 1);
        }
    }
}
