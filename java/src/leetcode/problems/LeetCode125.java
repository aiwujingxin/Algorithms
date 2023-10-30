package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/30 16:05
 */
public class LeetCode125 {


    //A man, a plan, a canal: Panama"
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isChar(s.charAt(left))) {
                left++;
            }
            while (left < right && !isChar(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isChar(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }
}
