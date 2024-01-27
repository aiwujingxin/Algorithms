package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/27 12:35
 */
public class LeetCode2904 {

    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int[] presum = new int[n + 1];
        for (int i = 1; i <= s.length(); i++) {
            presum[i] = presum[i - 1] + (s.charAt(i - 1) - '0');
        }
        String res = null;
        for (int i = 0; i < presum.length; i++) {
            for (int j = i + 1; j < presum.length; j++) {
                if (presum[j] - presum[i] == k) {
                    if (res == null || (j - i + 1) < res.length()) {
                        res = s.substring(i, j);
                    } else {
                        res = min(res, s.substring(i, j));
                    }
                }
            }
        }
        return res == null ? "" : res;
    }

    private String min(String res, String t) {
        if (res.equals(t)) {
            return res;
        }
        if (res.length() < t.length()) {
            return res;
        }
        if (res.length() > t.length()) {
            return t;
        }
        int n = res.length();
        for (int i = 0; i < n; i++) {
            if (res.charAt(i) < t.charAt(i)) {
                return res;
            }
            if (res.charAt(i) > t.charAt(i)) {
                return t;
            }
        }
        return res;
    }
}
