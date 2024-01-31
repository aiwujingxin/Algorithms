package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/31 10:18
 */
public class LeetCode1759 {

    public int countHomogenous(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int mod = 1000000007;
        int n = s.length();
        long res = 0;
        int left = 0;
        int right = 0;
        int[] freq = new int[26];
        int cnt = 0;
        while (right < n) {
            char c = s.charAt(right);
            if (freq[c - 'a'] == 0) {
                cnt++;
            }
            freq[c - 'a']++;
            while (left < right && cnt > 1) {
                char d = s.charAt(left);
                if (freq[d - 'a'] == 1) {
                    cnt--;
                }
                freq[d - 'a']--;
                left++;
            }
            res = (res + right - left + 1) % mod;
            right++;
        }
        return (int) res % mod;
    }
}
