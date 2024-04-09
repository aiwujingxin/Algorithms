package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:41
 */
public class LeetCode6 {

    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows <= 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        for (int i = 0; i < s.length(); i++) {
            int index = i % (2 * numRows - 2);
            if (index >= numRows) {
                index = 2 * numRows - 2 - index;
            }
            list.get(index).append(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(list.get(i).toString());
        }
        return sb.toString();
    }
}
