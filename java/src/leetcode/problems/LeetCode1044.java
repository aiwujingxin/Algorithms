package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 00:01
 */
public class LeetCode1044 {

    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = n;
        int start = -1;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            int index;
            if ((index = find(s, mid)) > -1) {
                start = index;
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return start == -1 ? "" : s.substring(start, start + left);
    }

    private int find(String txt, int len) {
        int mul = 26;
        long mod = (long) Math.pow(10, 11);
        long base = 1;
        for (int i = 0; i < len - 1; i++) {
            base = base * mul % mod;
        }
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * mul + txt.charAt(i)) % mod;
        }
        Set<Long> set = new HashSet<>();
        set.add(hash);
        int right = len;
        while (right < txt.length()) {
            // 缩小窗口，移出字符 ; 扩大窗口，移入字符
            hash = (mul * (hash - (txt.charAt(right - len) * base)) + (txt.charAt(right))) % mod;
            if (hash < 0) {
                hash = hash + mod;
            }
            if (!set.add(hash)) {
                return right - len + 1;
            }
            right++;
        }
        return -1;
    }
}
