package knowledge.algorithms.dp.backpack.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 11/5/25 05:01
 */
public class MinDistance_path {

    // 定义操作类型的常量，使代码更具可读性
    private static final int MATCH_OR_REPLACE = 0;
    private static final int DELETE = 1;
    private static final int INSERT = 2;


    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        int[][] choice = new int[m + 1][n + 1]; // 辅助表 g，记录决策
        // 初始化 DP 表和 choice 表的边界
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
            choice[i][0] = DELETE; // 从 word1 到空字符串，只能是删除
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
            choice[0][j] = INSERT; // 从空字符串到 word2，只能是插入
        }
        // 填充 DP 表和 choice 表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    choice[i][j] = MATCH_OR_REPLACE;
                } else {
                    // 比较三种操作的成本
                    int deleteCost = dp[i - 1][j];
                    int insertCost = dp[i][j - 1];
                    int replaceCost = dp[i - 1][j - 1];
                    // 找出最小成本并记录决策
                    // 优先级：替换 > 删除 > 插入
                    if (replaceCost <= deleteCost && replaceCost <= insertCost) {
                        dp[i][j] = replaceCost + 1;
                        choice[i][j] = MATCH_OR_REPLACE;
                    } else if (deleteCost <= insertCost) {
                        dp[i][j] = deleteCost + 1;
                        choice[i][j] = DELETE;
                    } else {
                        dp[i][j] = insertCost + 1;
                        choice[i][j] = INSERT;
                    }
                }
            }
        }
        // 根据 choice 表打印编辑操作
        System.out.println("从 '" + word1 + "' 变换到 '" + word2 + "' 的编辑步骤:");
        printEditOperations(choice, word1, word2);
        return dp[m][n];
    }

    /**
     * 根据 choice 表回溯并打印编辑操作。
     *
     * @param choice 记录决策的辅助表
     * @param word1  原始字符串
     * @param word2  目标字符串
     */
    public void printEditOperations(int[][] choice, String word1, String word2) {
        List<String> operations = new ArrayList<>();
        int i = word1.length();
        int j = word2.length();
        while (i > 0 || j > 0) {
            switch (choice[i][j]) {
                case MATCH_OR_REPLACE:
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        operations.add("无操作，保留 '" + word1.charAt(i - 1) + "'");
                    } else {
                        operations.add("将 '" + word1.charAt(i - 1) + "' 替换为 '" + word2.charAt(j - 1) + "'");
                    }
                    i--;
                    j--;
                    break;
                case DELETE:
                    operations.add("删除 '" + word1.charAt(i - 1) + "'");
                    i--;
                    break;
                case INSERT:
                    operations.add("插入 '" + word2.charAt(j - 1) + "'");
                    j--;
                    break;
            }
        }
        Collections.reverse(operations);
        if (operations.isEmpty()) {
            System.out.println("两个字符串相同，无需操作。");
        } else {
            for (String op : operations) {
                System.out.println("- " + op);
            }
        }
    }

    // Main 方法用于测试
    public static void main(String[] args) {
        MinDistance_path solver = new MinDistance_path();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("最小编辑距离: " + solver.minDistance(word1, word2));
        System.out.println("--------------------");
        String word3 = "intention";
        String word4 = "execution";
        System.out.println("最小编辑距离: " + solver.minDistance(word3, word4));
    }
}
