package leetcode.lists.offer;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-11-27 2:19 下午
 */
public class Offer60 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Offer60().dicesProbability(1)));
    }

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {

            //当前层
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {

                //dp前一层影响当前层
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
