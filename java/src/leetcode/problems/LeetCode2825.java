package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/8 11:55
 * @see LeetCode392
 */
public class LeetCode2825 {

    public boolean canMakeSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (match(s.charAt(i), t.charAt(j))) {
                j++;
            }
            i++;
        }
        return j == n;
    }

    private boolean match(char a, char b) {
        return a == b || (a - '0' + 1 == b - '0') || (a == 'z' && b == 'a');
    }
}
