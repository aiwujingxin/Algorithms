package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/10 22:14
 */
public class LeetCode331_dfs {

    public boolean isValidSerialization(String preorder) {
        return dfs(preorder, 0) >= preorder.length();
    }

    private int dfs(String preorder, int pos) {
        if (pos == -1) {
            return -1;
        }
        if (pos >= preorder.length()) {
            return -1;
        }
        if (preorder.charAt(pos) == '#') {
            return pos + 2;
        }
        pos = preorder.indexOf(',', pos);
        if (pos == -1) {
            return pos;
        }
        pos = dfs(preorder, pos + 1);
        if (pos == -1) {
            return pos;
        }
        return dfs(preorder, pos);
    }
}
