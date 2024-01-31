package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/31 15:26
 */
public class LeetCode1525 {

    public int numSplits(String s) {
        int n = s.length();
        int[] left = new int[n];
        int[] freq = new int[26];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 0) {
                cnt++;
            }
            freq[s.charAt(i) - 'a']++;
            left[i] = cnt;
        }
        int[] right = new int[n];
        freq = new int[26];
        cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (freq[s.charAt(i) - 'a'] == 0) {
                cnt++;
            }
            freq[s.charAt(i) - 'a']++;
            right[i] = cnt;
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (left[i] == right[i + 1]) {
                res++;
            }
        }
        return res;
    }
}
