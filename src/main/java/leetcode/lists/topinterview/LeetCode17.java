package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 00:31
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

        List<String> list = new ArrayList<>();
        dfs(0, digits, list, new StringBuilder());
        return list;
    }

    private void dfs(int index, String digits, List<String> list, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }

        String str = map.get(digits.charAt(index));
        for (int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            dfs(index + 1, digits, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
