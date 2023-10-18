package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 22:41
 * @see LeetCode779
 */
public class LeetCode1545 {
    public char findKthBit(int n, int k) {
        if (k == 1) {
            return '0';
        }
        int mid = 1 << (n - 1);
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            return invert(findKthBit(n - 1, mid * 2 - k));
        }
    }

    public char invert(char bit) {
        return (char) ('0' + '1' - bit);
    }
}
