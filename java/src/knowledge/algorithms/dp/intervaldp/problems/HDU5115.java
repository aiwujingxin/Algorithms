package knowledge.algorithms.dp.intervaldp.problems;

import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 7/7/25 00:42
 * @description <a href="https://acm.hdu.edu.cn/showproblem.php?pid=5115"></a>
 */
public class HDU5115 {

    public static class Main {
        static final long INF = (long) 1e18;
        static long[][] dp = new long[205][205];
        static int[] a = new int[205];
        static int[] b = new int[205];
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt(); // number of test cases
            for (int t = 1; t <= T; t++) {
                int n = sc.nextInt();
                for (int i = 1; i <= n; i++) {
                    a[i] = sc.nextInt(); // attack
                }
                b[0] = b[n + 1] = 0;
                for (int i = 1; i <= n; i++) {
                    b[i] = sc.nextInt(); // buff
                }
                // 初始化区间长度为1
                for (int i = 1; i <= n; i++) {
                    dp[i][i] = a[i] + b[i - 1] + b[i + 1];
                }
                // 区间长度从2到n
                for (int len = 2; len <= n; len++) {
                    for (int l = 1; l + len - 1 <= n; l++) {
                        int r = l + len - 1;
                        dp[l][r] = INF;
                        for (int k = l; k <= r; k++) {
                            long left = (k > l) ? dp[l][k - 1] : 0;
                            long right = (k < r) ? dp[k + 1][r] : 0;
                            long cost = left + right + a[k] + b[l - 1] + b[r + 1];
                            dp[l][r] = Math.min(dp[l][r], cost);
                        }
                    }
                }
                System.out.println("Case #" + t + ": " + dp[1][n]);
            }
        }
    }
}
