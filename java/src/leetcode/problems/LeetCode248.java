package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 21:19
 */
public class LeetCode248 {

    int count = 0;

    int strobogrammaticInRange(String low, String high) {
        dfs(low, high, "");
        dfs(low, high, "1");
        dfs(low, high, "0");
        dfs(low, high, "8");
        return count;
    }

    void dfs(String low, String high, String cur) {
        if (cur.length() > high.length()) {
            return;
        }
        if (cur.length() >= low.length()) {
            if (cur.length() == high.length() && cur.compareTo(high) > 0) {
                return;
            }
            if (cur.length() == low.length() && cur.compareTo(low) < 0) {
                return;
            }
            if (!(cur.length() > 1 && cur.charAt(0) == '0')) {
                count++;
            }
        }
        dfs(low, high, "0" + cur + "0");
        dfs(low, high, "1" + cur + "1");
        dfs(low, high, "6" + cur + "9");
        dfs(low, high, "8" + cur + "8");
        dfs(low, high, "9" + cur + "6");
    }

}
