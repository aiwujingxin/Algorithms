package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/15 22:23
 */
public class LeetCode172 {

    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n / 5;
            cnt += n;
        }
        return cnt;
    }
}
