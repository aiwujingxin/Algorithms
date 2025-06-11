package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/28 14:22
 */
public class LeetCode168 {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber >= 1) {
            char c = (char) ((columnNumber - 1) % 26 + 'A');
            sb.append(c);
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
