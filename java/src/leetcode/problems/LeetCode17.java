package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/15 23:50
 */
public class LeetCode17 {

    List<String> res;
    HashMap<Integer, String> map;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        map = new HashMap<>();
        res = new ArrayList<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        backtrack(0, digits, new StringBuilder());
        return res;
    }

    private void backtrack(int index, String digits, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char aChar : map.get(digits.charAt(index) - '0').toCharArray()) {
            sb.append(aChar);
            backtrack(index + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
