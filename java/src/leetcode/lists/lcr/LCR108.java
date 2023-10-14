package leetcode.lists.lcr;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/28 16:12
 */
public class LCR108 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        if (beginWord.length() != endWord.length()) {
            return 0;
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String next : getNext(cur, wordSet)) {
                    if (Objects.equals(next, endWord)) {
                        return step + 1;
                    }
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.add(next);
                }
            }
            step++;
        }
        return 0;
    }

    private List<String> getNext(String cur, HashSet<String> wordSet) {
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
                if (wordSet.contains(s)) {
                    list.add(s);
                }
            }
            chars[i] = t;
        }
        return list;
    }
}
