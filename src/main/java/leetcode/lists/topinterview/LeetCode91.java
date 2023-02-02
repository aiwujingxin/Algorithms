package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/23 17:32
 */
public class LeetCode91 {


    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < s.length(); i++) {
            //留它一个
            if (s.charAt(i) != '0') {
                dp[i + 1] = dp[i];
//                dp[i + 1] += dp[i]; 也可以这样写
            }
            //当作两个
            int num = Integer.parseInt(s.substring(i - 1, i + 1));
            if (num >= 10 && num <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
