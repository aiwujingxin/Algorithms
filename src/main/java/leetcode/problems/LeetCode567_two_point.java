package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 20:45
 */
public class LeetCode567_two_point {

    public static void main(String[] args) {
        System.out.println(new LeetCode567_two_point().checkInclusion("bcb", "abcbcf"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            cnt[s1.charAt(i) - 'a']--;
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            cnt[x]++;
            while (cnt[x] > 0) {
                //去除多余的不匹配的字符，
                cnt[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

}
