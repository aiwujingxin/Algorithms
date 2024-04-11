package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/04/11 13:09
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

    private void backtrack(int start, int n, List<List<Integer>> res, int k, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(i + 1, n, res, k, list);
            list.remove(list.size() - 1);
        }
    }
}
