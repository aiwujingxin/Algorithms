package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/28 14:03
 */
public class LeetCode171 {

    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.isEmpty()) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            res = res * 26 + c - 'A' + 1;
        }
        return res;
    }
}
