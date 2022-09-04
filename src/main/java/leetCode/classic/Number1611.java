package leetCode.classic;

/**
 * @author jingxinwu
 * @date 2021-12-06 12:18 上午
 */
public class Number1611 {


    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] lengths = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lengths[i] = shorter * (k - i) + longer * i;
        }
        return lengths;
    }


    //dp
    public int[] divingBoardV2(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        int gap = longer - shorter;
        if (gap == 0) {
            return new int[]{shorter * k};
        }
        int[] dp = new int[k + 1];
        dp[0] = shorter * k;
        for (int i = 1; i < k + 1; ++i) {
            dp[i] = dp[i - 1] + gap;
        }
        return dp;
    }
}
