package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 18:27
 */
public class LeetCode424 {

    public int characterReplacement(String s, int k) {
        int res = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            int right = 0;
            int left = 0;
            int cnt = 0;

            while (right < s.length()) {
                if (s.charAt(right) != c) {
                    cnt++;
                }
                while (left < right && cnt > k) {
                    if (s.charAt(left) != c) {
                        cnt--;
                    }
                    left++;
                }
                res = Math.max(res, right - left + 1);
                right++;
            }
        }
        return res;
    }
}
