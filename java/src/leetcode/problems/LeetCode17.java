package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 11:32
 */
public class LeetCode17 {

    String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < phone[digits.charAt(index) - '0'].length(); i++) {
            sb.append(phone[digits.charAt(index) - '0'].charAt(i));
            backtrack(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

