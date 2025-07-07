package knowledge.algorithms.dp.intervaldp.problems;

import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 6/7/25 22:26
 * @description POJ3280: 增删字母得到回文的最小花费 <a href="http://poj.org/problem?id=3280"></a>
 */
public class MinCostPalindrome {

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int k = sc.nextInt(); // 字符种类数
            int n = sc.nextInt(); // 字符串长度
            String s = sc.next(); // 字符串 s，长度应为 n
            int[] cost = new int[26]; // 每个字符的插入/删除最小代价
            for (int i = 0; i < k; i++) {
                String ch = sc.next();
                int insertCost = sc.nextInt();
                int deleteCost = sc.nextInt();
                cost[ch.charAt(0) - 'a'] = Math.min(insertCost, deleteCost);
            }
            int[][] dp = new int[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j] + cost[s.charAt(i) - 'a'], dp[i][j - 1] + cost[s.charAt(j) - 'a']);
                    }
                }
            }
            System.out.println(dp[0][n - 1]);
        }
    }
}
