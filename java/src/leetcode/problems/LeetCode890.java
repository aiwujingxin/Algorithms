package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2024.01.08 21:25
 */
public class LeetCode890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        for (String w : words) {
            if (check(w, pattern)) {
                list.add(w);
            }
        }
        return list;
    }

    private boolean check(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        HashMap<Character, Character> wMap = new HashMap<>();
        HashMap<Character, Character> pMap = new HashMap<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!wMap.containsKey(w)) {
                if (pMap.get(p) != null && pMap.get(p) != w) {
                    return false;
                }
                wMap.put(w, p);
                pMap.put(p, w);
            } else {
                if (wMap.get(w) != p) {
                    return false;
                }
            }
        }
        return true;
    }
}
