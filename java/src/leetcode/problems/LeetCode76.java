package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/10 12:44
 */
public class LeetCode76 {

    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int cnt = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int[] sArr = new int[256];
        int[] tArr = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tArr[t.charAt(i) - 'A']++;
            set.add(t.charAt(i));
        }
        int target = set.size();
        int l = 0;
        int len = Integer.MAX_VALUE;
        while (right < n) {
            char c = s.charAt(right);
            sArr[c - 'A']++;
            if (sArr[c - 'A'] == tArr[c - 'A']) {
                cnt++;
            }
            while (left <= right && cnt == target) {
                if (len > right - left + 1) {
                    len = right - left + 1;
                    l = left;
                }

                char d = s.charAt(left);
                if (sArr[d - 'A'] == tArr[d - 'A']) {
                    cnt--;
                }
                sArr[d - 'A']--;
                left++;
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(l, l + len);
    }
}
