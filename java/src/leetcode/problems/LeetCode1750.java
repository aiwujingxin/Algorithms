package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/2 11:39
 */
public class LeetCode1750 {

    public int minimumLength(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char c = s.charAt(left);
            while (left <= right && s.charAt(left) == c) {
                left++;
            }
            while (left <= right && s.charAt(right) == c) {
                right--;
            }
        }
        return right - left + 1;
    }
}
