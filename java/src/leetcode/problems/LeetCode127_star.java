package leetcode.problems;

import knowledge.algorithms.search.bfs.AStar;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 3/23/26 23:05
 */
public class LeetCode127_star {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        Integer result = new AStar().search(beginWord, endWord, cur -> {
            List<Map.Entry<String, Integer>> nexts = new ArrayList<>();
            char[] chars = cur.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char t = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == t) continue;
                    chars[i] = c;
                    String s = new String(chars);
                    if (dict.contains(s)) {
                        nexts.add(Map.entry(s, 1));
                        //  dict.remove(s); different from bfs, can not remove
                    }
                }
                chars[i] = t;
            }
            return nexts;
        }, AStar.H.HAMMING::applyAsInt, 1, Integer::sum);
        return result == null ? 0 : result;
    }
}
