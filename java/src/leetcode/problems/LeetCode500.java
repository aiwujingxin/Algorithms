package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/6 10:17
 */
public class LeetCode500 {

    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return new String[]{};
        }
        String[] strings = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        int[][] arr = new int[3][256];
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                arr[i][strings[i].charAt(j) - 'a']++;
            }
        }
        List<String> list = new ArrayList<>();
        for (String word : words) {
            for (int[] ints : arr) {
                if (check(word, ints)) {
                    list.add(word);
                    break;
                }
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private boolean check(String word, int[] arr) {
        for (int i = 0; i < word.length(); i++) {
            if (arr[Character.toLowerCase(word.charAt(i)) - 'a'] <= 0) {
                return false;
            }
        }
        return true;
    }
}
