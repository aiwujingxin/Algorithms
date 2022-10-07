package leetcode.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 02:25
 */
public class LeetCode127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int steps = 1;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                String curr = queue.poll();
                if (endWord.equals(curr)) {
                    return steps;
                }
                char[] chars = curr.toCharArray();
                for (int j = 0; j < beginWord.length(); j++) {
                    char temp = chars[j];
                    List<String> nexts = nextWords(chars, j);
                    for (String s : nexts) {
                        if (words.contains(s) && !visited.contains(s)) {
                            queue.add(s);
                            visited.add(s);
                        }
                    }
                    chars[j] = temp;
                }
            }
            steps++;
        }
        return steps;
    }


    private List<String> nextWords(char[] chars, int i) {
        List<String> list = new ArrayList<>();
        for (char j = 'a'; j <= 'z'; j++) {
            chars[i] = j;
            list.add(new String(chars));
        }
        return list;
    }
}
