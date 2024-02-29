package knowledge.dp.backpack.complete;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/28 15:52
 */
public class CompletePackTest {

    public static void main(String[] args) {
        System.out.println(cal(2, new int[]{1, 1}));
        System.out.println(cal1(2, new int[]{1, 1}));
    }

    public static int cal(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    public static int cal1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}
