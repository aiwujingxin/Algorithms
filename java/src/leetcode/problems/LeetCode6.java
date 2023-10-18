package leetcode.problems;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 13:00
 */
public class LeetCode6 {

    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || s.length() <= numRows || numRows == 1) {
            return s;
        }
        TreeMap<Integer, StringBuilder> map = new TreeMap<>();
        for (int i = 0; i <= numRows; i++) {
            map.put(i, new StringBuilder());
        }
        int cycle = 2 * (numRows - 1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int r = i % cycle;
            int index;
            if (r + 1 <= numRows) {
                index = r;
            } else {
                index = r - 2 * (r % numRows + 1);
            }
            map.get(index).append(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, StringBuilder> entry : map.entrySet())
            sb.append(entry.getValue());
        return sb.toString();
    }
}
