package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 17:17
 */
public class LeetCode246 {

    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            sb.append(map.get(num.charAt(i)));
        }
        char[] chars = sb.toString().toCharArray();
        reverse(chars, 0, chars.length - 1);

        return new String(chars).equals(num);
    }

    public void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++;
            j--;
        }
    }
}
