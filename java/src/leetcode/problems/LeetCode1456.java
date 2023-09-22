package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/20 20:25
 */
public class LeetCode1456 {

    public int maxVowels(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int right = 0;
        int left = 0;
        int count = 0;

        int ans = 0;
        while (right < s.length()) {

            if (isA(s.charAt(right))) {
                count++;
            }
            if (right - left + 1 > k) {
                if (isA(s.charAt(left))) {
                    count--;
                }
                left++;
            }
            if (right - left + 1 == k) {
                ans = Math.max(count, ans);
            }
            right++;
        }
        return ans;
    }

    public boolean isA(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
