package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 18:59
 * 剪枝
 * <a href="https://leetcode.cn/problems/factor-combinations/solutions/303977/you-xiang-xi-si-lu-by-yuangang-3/"></a>
 */
public class LeetCode254 {
    int m;

    public List<List<Integer>> getFactors(int n) {
        this.m = n;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, new ArrayList<>(), res, 2);
        return res;
    }

    private void backtrack(int num, List<Integer> list, List<List<Integer>> res, int minnum) {
        if (num < m) {
            list.add(num);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
        // opt minnum
        // opt i * i <= num
        for (int i = minnum; i * i <= num; i++) {
            if (num % i == 0) {
                list.add(i);
                backtrack(num / i, list, res, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
