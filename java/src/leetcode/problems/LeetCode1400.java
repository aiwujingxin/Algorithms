package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/26 17:41
 */
public class LeetCode1400 {

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int cnt = 0;
        for (int j : freq) {
            if (j % 2 == 1) {
                cnt++;
            }
        }
        return cnt <= k;
    }
}
