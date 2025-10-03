package leetcode.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.BiBFS;

import java.util.*;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 13:55
 */
public class LeetCode127_2bfs {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Function<String, List<String>> getNeighbors = (word) -> {
            List<String> neighbors = new ArrayList<>();
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char oldChar = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == oldChar) continue;
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (wordSet.contains(newWord)) {
                        neighbors.add(newWord);
                    }
                }
                chars[i] = oldChar;
            }
            return neighbors;
        };
        BiBFS<String> bfs = new BiBFS<>();
        return bfs.search(beginWord, endWord, getNeighbors) + 1;
    }
}
