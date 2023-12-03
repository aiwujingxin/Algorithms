package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/25 18:09
 */
public class LeetCode77 {

    public List<List<Integer>> combine(int n, int k) {
        if (n < 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, res, k, new ArrayList<>());
        return res;
    }

    private void backtrack(int index, int n, List<List<Integer>> res, int k, List<Integer> list) {
        if (index > n + 1) {
            return;
        }
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            backtrack(i + 1, n, res, k, list);
            list.remove(list.size() - 1);
        }
    }
}
