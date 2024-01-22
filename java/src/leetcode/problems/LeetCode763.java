package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 14:34
 */
public class LeetCode763 {

    public List<Integer> partitionLabels(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int pre = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']--;
            if (can(freq, pre, i, s)) {
                list.add(i - pre);
                pre = i;
            }
        }
        list.set(0, list.get(0) + 1);
        return list;
    }

    private boolean can(int[] freq, int pre, int i, String s) {
        for (int j = pre; j <= i; j++) {
            if (freq[s.charAt(j) - 'a'] > 0) {
                return false;
            }
        }
        return true;
    }
}
