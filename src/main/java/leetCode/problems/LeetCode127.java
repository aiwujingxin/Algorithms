package leetCode.problems;

import java.util.*;


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
        int wordSize = beginWord.length();
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                String curr = queue.poll();
                if (endWord.equals(curr)) {
                    return steps;
                }
                char[] wordChars = curr.toCharArray();
                for (int wl = 0; wl < wordSize; wl++) {
                    char temp = wordChars[wl];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[wl] = c;
                        String s = new String(wordChars);
                        if (words.contains(s) && !visited.contains(s)) {
                            queue.add(s);
                            visited.add(s);
                        }
                    }
                    wordChars[wl] = temp;
                }
            }
            steps++;
        }
        return 0;
    }
}
