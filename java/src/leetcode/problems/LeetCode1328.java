package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/29 13:41
 */
public class LeetCode1328 {

    public String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.isEmpty() || palindrome.length() == 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder(palindrome);
        boolean replaced = false;
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) == 'a') {
                continue;
            }
            sb.deleteCharAt(i);
            sb.insert(i, 'a');
            replaced = true;
            break;
        }
        if (!replaced) {
            sb.deleteCharAt(sb.length() - 1);
            sb.append('b');
        }
        return sb.toString();
    }
}
