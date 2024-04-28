package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 10:44
 */
public class LeetCode216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        bk(0, n, k, res, new ArrayList<>());
        return res;
    }

    private void bk(int start, int n, int k, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            bk(i + 1, n - i, k, res, list);
            list.remove(list.size() - 1);
        }
    }
}
