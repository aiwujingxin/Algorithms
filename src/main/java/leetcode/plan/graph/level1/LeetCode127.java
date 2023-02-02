package leetcode.plan.graph.level1;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/20 22:50
 */
public class LeetCode127 {

    public static void main(String[] args) {
        System.out.println(new LeetCode127().
                ladderLength("ymain", "oecij", new ArrayList<>(Arrays.asList("ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain"))));
    }

    //"ymain"
    //"oecij"
    //["ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"]

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size > 0) {
                String cur = queue.poll();

                List<String> nexts = getList(cur, set);
                for (String next : nexts) {
                    if (next.equals(endWord)) {
                        return step;
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
        return 0;
    }

    private List<String> getList(String cur, HashSet<String> set) {
        List<String> list = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char t = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == t) {
                    continue;
                }
                chars[i] = j;
                String s = new String(chars);
                if (set.contains(s)) {
                    list.add(s);
                }
            }
            chars[i] = t;
        }
        return list;
    }
}
