package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 5/5/26 16:49
 */
public class LeetCode1798 {

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int reach = 0;
        for (int coin : coins) {
            if (coin > reach + 1) break;
            reach += coin;
        }
        return reach + 1;
    }
}
