package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/11 19:46
 */
public class LeetCode301_backtrack {

    //https://leetcode.com/problems/remove-invalid-parentheses/discuss/391415/Java-Solution-with-Detailed-Comments-(easy-understand-readable)

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        // calculate the number of "(" and ")" we should delete
        int[] count = getDeleteCount(s);
        int leftCount = count[0];
        int rightCount = count[1];

        StringBuilder sb = new StringBuilder();
        backtrack(leftCount, rightCount, 0, 0, 0, sb, s, result, false, false);

        return result;
    }

    private int[] getDeleteCount(String s) {
        int L1 = 0, R1 = 0;
        int L2 = 0, R2 = 0;
        int leftCount = 0, rightCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch1 = s.charAt(i); // from left
            char ch2 = s.charAt(s.length() - i - 1); // from right
            if (ch1 == '(') {
                L1 += 1;
            } // remember to skip other letters

            if (ch1 == ')') {
                R1 += 1;
            }

            if (ch2 == '(') {
                L2 += 1;
            }
            if (ch2 == ')') {
                R2 += 1;
            }

            rightCount = Math.max(rightCount, R1 - L1);
            leftCount = Math.max(leftCount, L2 - R2);
        }
        return new int[]{leftCount, rightCount};
    }

    private void backtrack(int leftCount, int rightCount, int L, int R, int pos,
                           StringBuilder sb, String s, List<String> result,
                           boolean deletedLeft, boolean deletedRight) {
        // base case
        if (L < R) { // L < R (not balanced)
            return;
        }
        if (pos == s.length()) { // time to add the result
            if (leftCount == 0 && rightCount == 0 && L == R) { // check if it is a valid string
                result.add(sb.toString());
            }
            return;
        }

        char ch = s.charAt(pos);
        if (ch == '(') {
            // select
            if (!deletedLeft || s.charAt(pos - 1) != '(') { // check for duplicates
                sb.append(ch);
                backtrack(leftCount, rightCount, L + 1, R, pos + 1, sb, s, result, false, false);
                sb.deleteCharAt(sb.length() - 1);
            }
            // do not select it (delete)
            if (leftCount > 0) {
                backtrack(leftCount - 1, rightCount, L, R, pos + 1, sb, s, result, true, false);
            }
        } else if (ch == ')') {
            // select
            if (!deletedRight || s.charAt(pos - 1) != ')') { // check for duplicates
                sb.append(ch);
                backtrack(leftCount, rightCount, L, R + 1, pos + 1, sb, s, result, false, false);
                sb.deleteCharAt(sb.length() - 1);
            }
            // do not select it (delete)
            if (rightCount > 0) {
                backtrack(leftCount, rightCount - 1, L, R, pos + 1, sb, s, result, false, true);
            }
        } else { // other letter
            sb.append(ch);
            backtrack(leftCount, rightCount, L, R, pos + 1, sb, s, result, false, false);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
