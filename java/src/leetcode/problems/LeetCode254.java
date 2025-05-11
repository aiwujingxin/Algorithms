package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 18:59
 * @link <a href="https://leetcode.cn/problems/factor-combinations/solutions/303977/you-xiang-xi-si-lu-by-yuangang-3/"></a>
 */
public class LeetCode254 {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, 2, n, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int num, int start, int n, List<Integer> list, List<List<Integer>> res) {
        if (num < n) {
            list.add(num);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
        // opt start
        // opt i * i <= num
        for (int i = start; i * i <= num; i++) {
            if (num % i == 0) {
                list.add(i);
                backtrack(num / i, i, n, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
