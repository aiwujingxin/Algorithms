package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/24 18:50
 */
public class LeetCode125 {

    public static void main(String[] args) {
        System.out.println(new LeetCode125().isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }

            while (!Character.isLetterOrDigit(s.charAt(right)) && right > left) {
                right--;
            }

            //fixed
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
            }
            left++;
            right--;
        }

        return true;
    }
}
