package leetcode.lists.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/11 18:19
 */
public class LeetCode17 {
    HashMap<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        dfs(digits, 0, res, new StringBuilder());
        return res;
    }

    private void dfs(String digits, int index, List<String> res, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < digits.length(); i++) {
            char ch = digits.charAt(index);
            String str = map.get(ch);
            for (int j = 0; j < str.length(); j++) {
                sb.append(str.charAt(j));
                dfs(digits, index + 1, res, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}


