package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/5 00:20
 */
public class LeetCode921 {

    public int minAddToMakeValid(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            } else {
                left++;
            }
        }
        return left + right;
    }
}
