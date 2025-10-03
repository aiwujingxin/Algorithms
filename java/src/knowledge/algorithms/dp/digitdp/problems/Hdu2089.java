package knowledge.algorithms.dp.digitdp.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 9/27/25 23:07
 * @description 给定区间[n, m]，求区间内 不包含数字 ‘4’ 且不包含连续 ‘62’ 的数字个数。
 * <a href="https://vjudge.net/problem/HDU-2089"></a>
 */
public class Hdu2089 {

    public class Main {
        static int[] digits = new int[10];
        static int[][][] dp = new int[10][2][2]; // dp[pos][preIs6][isLimit]

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                if (n == 0 && m == 0) break;
                System.out.println(solve(m) - solve(n - 1));
            }
            sc.close();
        }

        static int solve(int num) {
            if (num < 0) return 0;
            int len = 0;
            while (num > 0) {
                digits[len++] = num % 10;
                num /= 10;
            }
            // 反转 digits 数组，让高位在索引 0
            for (int i = 0; i < len / 2; i++) {
                int t = digits[i];
                digits[i] = digits[len - 1 - i];
                digits[len - 1 - i] = t;
            }
            // 初始化 dp 为 -1
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 2; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }
            return dfs(0, false, true, len);
        }

        static int dfs(int pos, boolean preIs6, boolean isLimit, int len) {
            if (pos == len) return 1; // 成功生成一个有效数字
            int pre = preIs6 ? 1 : 0;
            int limit = isLimit ? 1 : 0;
            if (dp[pos][pre][limit] != -1) return dp[pos][pre][limit];

            int res = 0;
            int up = isLimit ? digits[pos] : 9;
            for (int d = 0; d <= up; d++) {
                if (d == 4) continue;
                if (preIs6 && d == 2) continue;
                res += dfs(pos + 1, d == 6, isLimit && (d == up), len);
            }
            dp[pos][pre][limit] = res;
            return res;
        }
    }
}
