package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 18:59
 */
public class LeetCode254 {
    int m;

    public static void main(String[] args) {
        System.out.println(new LeetCode254().getFactors(12));
        System.out.println(new LeetCode254().getFactors(18));
        System.out.println(new LeetCode254().getFactors(32));
        System.out.println(new LeetCode254().getFactors(37));
        System.out.println(new LeetCode254().getFactors(1));
        System.out.println(new LeetCode254().getFactors(128));
        System.out.println(new LeetCode254().getFactors(2097152));
    }

    public List<List<Integer>> getFactors(int n) {
        this.m = n;
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, new ArrayList<>(), res, 2);
        return res;
    }

    private void dfs(int num, List<Integer> list, List<List<Integer>> res, int minnum) {
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
                dfs(num / i, list, res, i);
                list.remove(list.size() - 1);
            }
        }
    }

}
