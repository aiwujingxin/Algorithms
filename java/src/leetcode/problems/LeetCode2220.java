package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/14/25 23:54
 */
public class LeetCode2220 {

    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
