package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/3 14:23
 */
public class LeetCode5 {

    public static void main(String[] args) {
        System.out.println(new LeetCode5().longestPalindrome("abba"));
        System.out.println(new LeetCode5().longestPalindrome("ss"));
        System.out.println(new LeetCode5().longestPalindrome("s"));
        System.out.println(new LeetCode5().longestPalindrome("aba"));
        System.out.println(new LeetCode5().longestPalindrome("babad"));
    }

    String res = "";
    String temp;

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            find(s, i, i);
            if (temp.length() > res.length()) {
                res = temp;
            }
            find(s, i, i + 1);
            if (temp.length() > res.length()) {
                res = temp;
            }

        }
        return res;

    }

    // "abba"
    //   12
    //  0  3
    private void find(String s, int i, int j) {
        if (s.charAt(i) != s.charAt(j)) {
            return;
        }
        while (i > 0 && j < s.length() - 1 && s.charAt(i - 1) == s.charAt(j + 1)) {
            i--;
            j++;
        }
        temp = s.substring(i, j + 1);
    }
}
