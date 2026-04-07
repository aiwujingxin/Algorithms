package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 3/23/26 22:37
 */
public class LeetCode127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (endWord.equals(cur)) return step;
                List<String> nexts = cal(cur, set);
                queue.addAll(nexts);
            }
            step++;
        }
        return 0;
    }

    private List<String> cal(String cur, Set<String> set) {
        List<String> list = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char t = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == t) continue;
                chars[i] = c;
                String s = new String(chars);
                if (set.contains(s)) {
                    list.add(s);
                    set.remove(s);
                }
            }
            chars[i] = t;
        }
        return list;
    }
}
