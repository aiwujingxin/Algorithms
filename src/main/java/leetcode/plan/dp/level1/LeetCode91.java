package leetcode.plan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 19:41
 */
public class LeetCode91 {

    public static void main(String[] args) {
//        System.out.println(new LeetCode91().numDecodings("12")); //0
        System.out.println(new LeetCode91().numDecodings("106")); //0
    }

    //copy
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if ((s.charAt(i) != '0')) {
                dp[i + 1] = dp[i];
            }
            int num = Integer.parseInt(s.substring(i - 1, i + 1));
            if (10 <= num && num <= 26) {
                dp[i + 1] += dp[i - 1] + 1;
            }
        }
        return dp[dp.length - 1];
    }
}
