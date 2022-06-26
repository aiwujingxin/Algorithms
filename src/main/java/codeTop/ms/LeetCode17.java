package codeTop.ms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jingxinwu
 * @date 2022-02-16 2:27 PM
 */
public class LeetCode17 {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        HashMap<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<String> list = new ArrayList<>();
        helper(list, map, digits, 0, new StringBuilder());
        return list;
    }

    private void helper(List<String> list, HashMap<Character, String> map, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = map.get(digits.charAt(index));
        //fix 从0开始
        for (int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            helper(list, map, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
