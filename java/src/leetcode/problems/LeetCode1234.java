package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/18 12:27
 */
public class LeetCode1234 {

    public int balancedString(String S) {
        char[] s = S.toCharArray();
        int[] cnt = new int['X']; // 也可以用哈希表，不过数组更快一些
        for (int c : s) {
            cnt[c]++;
        }
        int n = s.length, m = n / 4;
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
            return 0; // 已经符合要求啦
        }
        int ans = n, left = 0;
        int right = 0;
        while (right < n) {
            cnt[s[right]]--;
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                cnt[s[left]]++;
                left++;
            }
            right++;
        }
        return ans;
    }
}
