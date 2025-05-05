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
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currentRow = 0;
        boolean goingDown = false;
        for (int i = 0; i < s.length(); i++) {
            rows[currentRow].append(s.charAt(i));
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown; // 到达顶行或底行时改变方向
            }
            currentRow += goingDown ? 1 : -1; // 根据方向调整行号
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }
}
