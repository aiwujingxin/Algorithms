package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/30 16:05
 */
public class LeetCode125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))) return false;
        }
        return true;
    }
}
