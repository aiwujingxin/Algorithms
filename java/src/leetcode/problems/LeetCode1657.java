package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/9 13:43
 */
public class LeetCode1657 {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] freq1 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
        }
        int[] freq2 = new int[26];
        for (int i = 0; i < word2.length(); i++) {
            freq2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < freq1.length; i++) {
            if (freq2[i] > 0 && freq1[i] <= 0) {
                return false;
            }
        }
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < freq1.length; i++) {
            map1.put(freq1[i], map1.getOrDefault(freq1[i], 0) + 1);
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < freq2.length; i++) {
            map2.put(freq2[i], map2.getOrDefault(freq2[i], 0) + 1);
        }
        return map1.equals(map2);
    }

}
