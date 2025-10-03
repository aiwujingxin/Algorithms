package leetcode.problems;

import knowledge.datastructure.string.match.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 19:48
 * @see LeetCode392
 */
public class LeetCode792 {

    public int numMatchingSubseq(String s, String[] words) {
        int cnt = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (isSubsequence(entry.getKey(), s)) {
                cnt += entry.getValue();
            }
        }
        return cnt;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            if (i < s.length() && s.charAt(i) == c) i++;
        }
        return i == s.length();
    }

    public int numMatchingSubseq_trie(String s, String[] words) {
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        return trie.searchSubSeq(s);
    }

    public int numMatchingSubseq_bs(String s, String[] words) {
        List<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        int res = words.length;
        for (String word : words) {
            if (word.length() > s.length()) {
                res--;
                continue;
            }
            int current = -1;
            for (char c : word.toCharArray()) {
                List<Integer> indices = pos[c - 'a'];
                int left = 0, right = indices.size() - 1;
                int nextPos = -1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (indices.get(mid) > current) {
                        nextPos = indices.get(mid);
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                if (nextPos == -1) {
                    res--;
                    break;
                }
                current = nextPos;
            }
        }
        return res;
    }
}
