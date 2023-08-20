package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 00:50
 */

public class Offer62_dp {

    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
