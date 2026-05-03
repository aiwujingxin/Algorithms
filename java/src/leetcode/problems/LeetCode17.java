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
        if (digits.isEmpty()) return res;
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int i, StringBuilder sb) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c : phone[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            backtrack(digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    class Solution_OPT {
        // 1. 使用二维 char 数组代替 String 数组，省去 toCharArray() 的开销
        private static final char[][] PHONE = {
                {}, {},
                {'a','b','c'}, {'d','e','f'}, {'g','h','i'},
                {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'},
                {'t','u','v'}, {'w','x','y','z'}
        };

        public List<String> letterCombinations(String digits) {
            int len = digits.length();
            if (len == 0) return new ArrayList<>();

            char[] digitsArr = digits.toCharArray();

            // 2. 提前计算好最终结果的数量，一次性分配 ArrayList 容量，绝对不触发动态扩容
            int capacity = 1;
            for (char d : digitsArr) {
                capacity *= PHONE[d - '0'].length;
            }
            List<String> res = new ArrayList<>(capacity);

            // 3. 使用固定长度的 char[] 替代 StringBuilder
            backtrack(digitsArr, 0, new char[len], res);
            return res;
        }

        private void backtrack(char[] digits, int i, char[] path, List<String> res) {
            if (i == digits.length) {
                // 只有在得到完整结果时，才 new 一个 String 对象
                res.add(new String(path));
                return;
            }

            // 4. 直接遍历预定义的 char 数组
            for (char c : PHONE[digits[i] - '0']) {
                path[i] = c; // 5. 直接通过索引覆盖，彻底干掉 append() 和 deleteCharAt() 的开销
                backtrack(digits, i + 1, path, res);
            }
        }
    }
}

