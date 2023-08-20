package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/5 00:14
 */
public class LeetCode2743 {

    public int numberOfSpecialSubstrings(String s) {
        int ans = 0;
        int[] count = new int[128];
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            count[s.charAt(right)]++;
            while (count[s.charAt(right)] == 2) {
                count[s.charAt(left)]--;
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
