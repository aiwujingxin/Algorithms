package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/17/25 17:12
 */
public class LeetCode1009 {

    public int bitwiseComplement(int n) {
        return n == 0 ? 1 : n ^ ((1 << 32 - Integer.numberOfLeadingZeros(n)) - 1);
    }
}
