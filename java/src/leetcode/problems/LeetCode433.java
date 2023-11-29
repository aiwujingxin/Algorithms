package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/29 15:46
 */
public class LeetCode433 {

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (bank == null || bank.length == 0) {
            return -1;
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(endGene)) {
            return -1;
        }
        HashSet<String> visited = new HashSet<>();
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (Objects.equals(cur, endGene)) {
                    return step;
                }
                if (visited.contains(cur)) {
                    continue;
                }
                visited.add(cur);
                List<String> next = getList(cur, chars, visited, set);
                queue.addAll(next);
            }
            step++;
        }
        return -1;
    }


    private List<String> getList(String cur, char[] chars, HashSet<String> visited, HashSet<String> set) {
        List<String> list = new ArrayList<>();
        char[] cs = cur.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char t = cs[i];
            for (char c : chars) {
                if (c == t) {
                    continue;
                }
                cs[i] = c;
                String s = new String(cs);
                if (visited.contains(s) || !set.contains(s)) {
                    continue;
                }
                list.add(s);
            }
            cs[i] = t;
        }
        return list;
    }
}
