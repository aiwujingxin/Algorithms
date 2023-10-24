package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 21:58
 */
public class LeetCode1561 {

    public int maxCoins(int[] piles) {
        if (piles == null || piles.length == 0 || piles.length % 3 != 0) {
            return 0;
        }

        Arrays.sort(piles);
        int right = piles.length - 2;
        int left = 0;
        int res = 0;
        while (right > left) {
            res += piles[right];
            left++;
            right -= 2;
        }
        return res;
    }
}
