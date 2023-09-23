package leetcode.lists.LCR;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 12:01
 */
public class LCR3 {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = bit(i);
        }
        return res;
    }

    private int bit(int n) {
        int cnt = 0;
        while (n > 0) {
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }
}
