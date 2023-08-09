package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/1 13:12
 */
public class LeetCode254_TEL {

    public List<List<Integer>> getFactors(int n) {
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
