package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 22:41
 * @see LeetCode779
 */
public class LeetCode1545 {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        while (sb.length() < k) {
            int i = sb.length() - 1;
            sb.append("1");
            while (i >= 0) {
                char c = sb.charAt(i--) == '1' ? '0' : '1';
                sb.append(c);
            }
        }
        return sb.charAt(k - 1);
    }

    public char findKthBit_dfs(int n, int k) {
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
