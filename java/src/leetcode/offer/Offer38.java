package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 00:19
 */
public class Offer38 {
    List<String> list;

    public String[] permutation(String s) {
        if (s == null || s.isEmpty()) {
            return new String[]{};
        }
        list = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtrack(0, chars);
        String[] strings = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i);
        }
        return strings;
    }

    private void backtrack(int index, char[] chars) {
        if (index == chars.length) {
            list.add(new String(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = index; j < chars.length; j++) {
            if (set.contains(chars[j])) {
                continue;
            }
            set.add(chars[j]);
            swap(index, j, chars);
            backtrack(index + 1, chars);
            swap(index, j, chars);
        }
    }

    private void swap(int index, int j, char[] chars) {
        char t = chars[index];
        chars[index] = chars[j];
        chars[j] = t;
    }
}
