package leetcode.lists.LCP;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/21 00:06
 */
public class LCP06 {

    public int minCount(int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int res = 0;
        for (int coin : coins) {
            if (coin % 2 == 1) {
                res += coin / 2 + 1;
            } else {
                res += coin / 2;
            }
        }
        return res;
    }
}
