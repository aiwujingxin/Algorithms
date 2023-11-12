package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/12 13:49
 */
public class LeetCode717 {

    public boolean isOneBitCharacter(int[] bits) {
        return dfs(bits, 0);
    }

    private boolean dfs(int[] bits, int index) {
        if (index == bits.length) {
            return false;
        }
        if (index == bits.length - 1) {
            return bits[index] == 0;
        }
        if (bits[index] == 0) {
            return dfs(bits, index + 1);
        }
        return dfs(bits, index + 2);
    }
}
