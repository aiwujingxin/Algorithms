package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:41
 */
public class LeetCode6 {

    public String convert(String s, int numRows) {
        if (s.isEmpty() || numRows == 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int curRow = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            rows[curRow].append(s.charAt(i));
            if (curRow == 0 || curRow == numRows - 1) {
                flag = !flag;
            }
            curRow += flag ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }
}
