package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 14:21
 */

public class LeetCode216 {
    int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int index, int target, int sum, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == k) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i <= 9; i++) {
            list.add(i);
            backtrack(i + 1, target, sum + i, res, list);
            list.remove(list.size() - 1);
        }
    }
}
