package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/19 14:20
 */
public class LeetCode6 {

    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
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
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb);
        }
        return res.toString();
    }
}
