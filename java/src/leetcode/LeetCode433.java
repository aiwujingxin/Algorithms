package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/20 22:34
 */
public class LeetCode433 {

    char[] ch = new char[]{'A', 'C', 'G', 'T'};

    //"AAAAAAAA"
    //"CCCCCCCC"
    //["AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA","CCCCCCCC"]
    public static void main(String[] args) {
        System.out.println(new LeetCode433().minMutation("AAAAAAAA", "CCCCCCCC", new String[]{"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA", "CCCCCCCC"}));

    }

    public int minMutation(String start, String end, String[] bank) {

        if (start.equals(end)) {
            return 0;
        }
        HashSet<String> bset = new HashSet<>(Arrays.asList(bank));

        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            step++;

            int size = queue.size();
            while (size > 0) {
                String cur = queue.poll();
                List<String> nexts = getList(cur);
                for (String next : nexts) {
                    if (Objects.equals(next, end) && bset.contains(next)) {
                        return step;
                    }
                    if (!bset.contains(next)) {
                        continue;
                    }
                    if (visited.contains(next)) {
                        continue;
                    }

                    queue.add(next);
                    visited.add(next);
                }
                size--;
            }
        }
        return -1;
    }

    private List<String> getList(String cur) {
        List<String> list = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char t = chars[i];
            for (char c : ch) {
                if (t == c) {
                    continue;
                }
                chars[i] = c;
                list.add(new String(chars));
            }
            chars[i] = t;
        }
        return list;
    }
}
