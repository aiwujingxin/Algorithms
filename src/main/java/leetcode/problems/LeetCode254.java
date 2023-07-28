package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

    //== TEL ==
    public List<List<Integer>> getFactors_TEL(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, new ArrayList<>(), res, new HashSet<>());
        res.remove(0);
        return res;
    }

    private void dfs(int num, List<Integer> list, List<List<Integer>> res, HashSet<String> set) {
        list.add(num);
        String s = convert(list);
        if (!set.contains(s)) {
            res.add(new ArrayList<>(list));
            set.add(s);
        }
        list.remove(list.size() - 1);
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                list.add(i);
                dfs(num / i, list, res, set);
                list.remove(list.size() - 1);
            }
        }
    }

    public String convert(List<Integer> list) {
        Integer[] array = list.toArray(new Integer[0]);
        Arrays.sort(array);
        StringBuilder s = new StringBuilder();
        for (Integer integer : array) {
            s.append(integer);
        }
        return s.toString();
    }
}
