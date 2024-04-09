package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/02/01 00:01
 * @see LeetCode718
 */
public class LeetCode1044 {

    public String longestDupSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = n;
        int start = -1;
        while (l < r) {
            int mid = (r + l + 1) / 2;
            int index = search(s, mid);
            if (index > -1) {
                start = index;
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return start == -1 ? "" : s.substring(start, start + l);
    }

    private int search(String txt, int len) {
        int mul = 26;
        long mod = (long) Math.pow(10, 11);
        long pow = 1;
        for (int i = 0; i < len - 1; i++) {
            pow = pow * mul % mod;
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
            hash = hash - txt.charAt(right - len) * pow;
            hash = (mul * hash + txt.charAt(right)) % mod;
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
