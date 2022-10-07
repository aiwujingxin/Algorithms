package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/29 00:36
 */
public class LeetCode279 {

    public static void main(String[] args) {
        System.out.println(new LeetCode279().numSquares(12));
    }

    public int numSquares(int n) {
        int[] dp = new int[n];
        //fix i = 1
        for (int i = 1; i < n; i++) {
            int temp = Integer.MAX_VALUE;
            //fix j = 1
            for (int j = 1; j * j <= i; j++) {
                temp = Math.min(temp, dp[i - j * j]);
            }
            dp[i] = temp + 1;
        }
        return dp[dp.length - 1];
    }
}
