package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/6/25 23:49
 */
public class LeetCode1332 {

    public int removePalindromeSub(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return 2;
            i++;
            j--;
        }
        return 1;
    }
}
