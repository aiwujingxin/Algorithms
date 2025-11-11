package knowledge.algorithms.dp.backpack.solution;

/**
 * @author wujingxinit@outlook.com
 * @date 11/5/25 05:05
 */
public class LCS_path {

    // 定义方向常量，增加代码可读性
    private static final int FROM_TOP_LEFT = 0; // 匹配，来自左上
    private static final int FROM_TOP = 1;      // 不匹配，来自上方
    private static final int FROM_LEFT = 2;     // 不匹配，来自左方

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        int[][] choice = new int[m + 1][n + 1]; // 辅助表 g，记录决策
        // 填充 DP 表和 choice 表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    choice[i][j] = FROM_TOP_LEFT;
                } else {
                    if (dp[i - 1][j] >= dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                        choice[i][j] = FROM_TOP;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                        choice[i][j] = FROM_LEFT;
                    }
                }
            }
        }
        // 根据 choice 表回溯并打印 LCS
        System.out.println("最长公共子序列 (LCS) 是: " + getLCS(choice, text1));
        return dp[m][n];
    }

    /**
     * 根据 choice 表回溯，构建并返回最长公共子序列字符串。
     *
     * @param choice 记录决策的辅助表
     * @param text1  字符串1 (我们只需要 text1 来获取字符)
     * @return 最长公共子序列字符串
     */
    public String getLCS(int[][] choice, String text1) {
        StringBuilder lcs = new StringBuilder();
        int i = text1.length();
        int j = choice[0].length - 1; // 获取 n 的值
        while (i > 0 && j > 0) {
            switch (choice[i][j]) {
                case FROM_TOP_LEFT:
                    // 只有来自左上角，才说明字符是 LCS 的一部分
                    lcs.append(text1.charAt(i - 1));
                    i--;
                    j--;
                    break;
                case FROM_TOP:
                    // 来自上方，说明放弃了 text1[i-1]，向上移动
                    i--;
                    break;
                case FROM_LEFT:
                    // 来自左方，说明放弃了 text2[j-1]，向左移动
                    j--;
                    break;
            }
        }
        // 因为是反向构建的，所以需要反转
        return lcs.reverse().toString();
    }

    // Main 方法用于测试
    public static void main(String[] args) {
        LCS_path solver = new LCS_path();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("Input: text1 = \"" + text1 + "\", text2 = \"" + text2 + "\"");
        System.out.println("LCS 长度: " + solver.longestCommonSubsequence(text1, text2));
        System.out.println("--------------------");
        String text3 = "AGGTAB";
        String text4 = "GXTXAYB";
        System.out.println("Input: text1 = \"" + text3 + "\", text2 = \"" + text4 + "\"");
        System.out.println("LCS 长度: " + solver.longestCommonSubsequence(text3, text4));
        System.out.println("--------------------");
    }
}
