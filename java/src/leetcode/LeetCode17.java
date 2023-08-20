package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-16 10:36 下午
 */
public class LeetCode17 {

    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        System.out.println(leetCode17.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        HashMap<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(phoneMap, digits, 0, res, new StringBuilder());
        return res;
    }

    private void backtrack(HashMap<Character, String> phoneMap, String digits, Integer index, List<String> res,
                           StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                sb.append(letters.charAt(i));
                backtrack(phoneMap, digits, index + 1, res, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
