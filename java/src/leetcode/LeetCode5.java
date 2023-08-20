package leetcode;

/**
 * @author jingxinwu
 * @date 2021-06-06 12:10 下午
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int one = helper(s, i, i);
            int two = helper(s, i, i + 1);

            int temp = Math.max(one, two);

            if (end - start < temp) {
                start = i - (temp - 1) / 2;
                end = i + (temp) / 2;
            }

        }

        return s.substring(start, end + 1);
    }

    public int helper(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
