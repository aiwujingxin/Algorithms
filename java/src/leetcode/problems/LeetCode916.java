package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/29/25 13:09
 * @description 看透执行本质 优化代码时间复杂度
 */
public class LeetCode916 {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int[][] chars = new int[words2.length][26];
        for (int i = 0; i < words2.length; i++) {
            for (int j = 0; j < words2[i].length(); j++) {
                chars[i][words2[i].charAt(j) - 'a']++;
            }
        }
        int[] freq = new int[26];
        for (int j = 0; j < 26; j++) {
            for (int i = 0; i < words2.length; i++) {
                freq[j] = Math.max(freq[j], chars[i][j]);
            }
        }
        for (String s : words1) {
            if (check(freq, s)) {
                list.add(s);
            }
        }
        return list;
    }

    public boolean check(int[] freq, String word) {
        int[] ch = new int[26];
        for (int i = 0; i < word.length(); i++) {
            ch[word.charAt(i) - 'a']++;
        }
        for (int j = 0; j < 26; j++) {
            if (ch[j] < freq[j]) {
                return false;
            }
        }
        return true;
    }
}
