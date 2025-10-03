package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/6 15:59
 */
public class LeetCode2745 {

    public int longestString(int x, int y, int z) {
        return (Math.min(x, y) * 2 + z + (x != y ? 1 : 0)) * 2;
    }
}
