package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 17:44
 */
public class LeetCode461 {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
