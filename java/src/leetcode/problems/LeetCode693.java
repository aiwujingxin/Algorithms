package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/12 12:59
 */
public class LeetCode693 {

    public boolean hasAlternatingBits(int n) {
        for (int i = 1; i < Integer.SIZE - Integer.numberOfLeadingZeros(n); i++) {
            if (((n >> i & 1) ^ (n >> (i - 1) & 1)) == 0)
                return false;
        }
        return true;
    }
}
