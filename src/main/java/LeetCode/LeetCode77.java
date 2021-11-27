package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-26 2:13 下午
 */
public class LeetCode77 {

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0) {
            return new ArrayList<>(new ArrayList<>());
        }
        List<List<Integer>> res = new ArrayList<>();

        helper(n, k, res, 0, new ArrayList<>());

        return res;
    }

    private void helper(int n, int k, List<List<Integer>> res, int index, ArrayList<Integer> temp) {

        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
        }

        for (int i = index; i < n; i++) {
            temp.add(i);
            helper(n, k, res, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
