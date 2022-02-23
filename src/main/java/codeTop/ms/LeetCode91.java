package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-17 2:53 PM
 */
public class LeetCode91 {

    public static void main(String[] args) {
        System.out.println(new LeetCode91().numDecodings("06"));
    }

    public int numDecodings(String s) {
        //fix s.charAt(0) == '0'
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < s.length(); i++) {
            //留它一个
            if (s.charAt(i) != '0') {
                dp[i + 1] += dp[i];
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
