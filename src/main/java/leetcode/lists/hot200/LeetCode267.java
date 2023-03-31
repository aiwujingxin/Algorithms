package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/12 14:12
 */
public class LeetCode267 {

    public static void main(String[] args) {
        System.out.println(new LeetCode267().generatePalindromes("aaa"));
    }

    public List<String> generatePalindromes(String s) {

        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Set<String> res = new HashSet<>();
        StringBuilder str = new StringBuilder();
        int count = 0;
        String single = "";
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                count++;
                single = String.valueOf(entry.getKey());
                if (entry.getValue() / 2 > 0) {
                    str.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue() / 2)));
                }
            } else {
                str.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue() / 2)));
            }
            if (count >= 2) {
                return new ArrayList<>();
            }
        }
        dfs(str.toString().toCharArray(), res, 0, single);
        return new ArrayList<>(res);
    }

    private void dfs(char[] chars, Set<String> res, int index, String single) {

        if (index == chars.length) {
            res.add(new String(chars) + single + new StringBuilder(new String(chars)).reverse());
            res.add(new StringBuilder(new String(chars)).reverse() + single + new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            dfs(chars, res, index + 1, single);
            swap(chars, i, index);
        }
    }

    private void swap(char[] chars, int i, int index) {
        char t = chars[i];
        chars[i] = chars[index];
        chars[index] = t;
    }
}
