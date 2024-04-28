package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/14 18:10
 * @see LeetCode424
 */
public class LeetCode1156 {

    public int maxRepOpt1(String text) {
        int n = text.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[text.charAt(i) - 'a']++;
        }
        int res = 0;
        for (char cur = 'a'; cur <= 'z'; cur++) {
            int left = 0;
            int right = 0;
            int other = 0;
            while (right < n) {
                char c = text.charAt(right);
                if (c != cur) {
                    other++;
                }
                while (left < right && other > 1) {
                    char d = text.charAt(left);
                    if (d != cur) {
                        other--;
                    }
                    left++;
                }
                if (other == 1) {
                    if (freq[cur - 'a'] >= right - left + 1) {
                        res = Math.max(res, right - left + 1);
                    }
                }
                if (other == 0) {
                    res = Math.max(res, right - left + 1);
                }
                right++;
            }
        }
        return res;
    }
}
