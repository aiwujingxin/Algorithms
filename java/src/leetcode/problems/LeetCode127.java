package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/30 21:17
 */
public class LeetCode127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) {
            return -1;
        }
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 0;
        HashSet<String> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (Objects.equals(cur, endWord)) {
                    return step + 1;
                }
                if (set.contains(cur)) {
                    continue;
                }
                set.add(cur);
                queue.addAll(getNext(cur, wordSet, set));
            }
            step++;
        }
        return 0;
    }

    private List<String> getNext(String cur, HashSet<String> wordSet, HashSet<String> set) {
        List<String> list = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char t = chars[i];
            for (char a = 'a'; a <= 'z'; a++) {
                chars[i] = a;
                String s = new String(chars);
                if (set.contains(s)) {
                    continue;
                }
                if (wordSet.contains(s)) {
                    list.add(s);
                }
            }
            chars[i] = t;
        }
        return list;
    }
}
