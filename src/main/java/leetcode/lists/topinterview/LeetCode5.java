package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/20 23:55
 */
public class LeetCode5 {


    public static void main(String[] args) {
        System.out.println(new LeetCode5().longestPalindrome("babad"));
        System.out.println(new LeetCode5().longestPalindrome("cbbd"));
    }

    String res = "";

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }


        for (int i = 0; i < s.length() -1; i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }

        return res;
    }

    //babad
    private void helper(String s, int i, int j) {

        if (s.charAt(i) != s.charAt(j)) {
            return;
        }
        while (i > 0 && j < s.length() - 1 && s.charAt(i - 1) == s.charAt(j + 1)) {
            i--;
            j++;
        }
        // 1 2

        if (j - i + 1 > res.length()) {
            System.out.println(i);
            System.out.println(j);
            res = s.substring(i, j + 1);
        }
    }
}
