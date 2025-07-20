package knowledge.algorithms.dp.intervaldp.problems;

import java.io.*;
import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/10 21:44
 * @description 石子合并
 * @link <a href="https://www.acwing.com/problem/content/284/">
 */
public class AcWing282 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = n + 1;
        int[][] dp = new int[n][n];
        int[] s = new int[n];
        for (int i = 1; i < n; i++) {
            s[i] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            s[i] += s[i - 1];
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                System.out.println("子问题 dp[" + i + "][" + j + "]");
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    System.out.println("划分点 k=" + k + "：dp[" + i + "][" + k + "] + dp[" + (k + 1) + "][" + j + "] + (s[" + j + "] - s[" + (i - 1) + "])");
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + (s[j] - s[i - 1]));
                }
            }
        }
        System.out.println(dp[1][n - 1]);
    }


    class Main_opt {

        public static void main(String[] args) throws IOException {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(read.readLine().trim()) + 1;
            int[][] dp = new int[n][n];
            int[][] opt = new int[n][n]; // 决策点数组
            int[] s = new int[n];
            String[] str = read.readLine().split("\\s+");
            for (int i = 1; i < n; i++) {
                s[i] = Integer.parseInt(str[i - 1]);
            }
            // 前缀和
            for (int i = 1; i < n; i++) {
                s[i] += s[i - 1];
                dp[i][i] = 0;
                opt[i][i] = i; // 初始决策点设为自身
            }
            for (int i = n - 1; i >= 1; i--) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    // 四边形优化：缩小 k 的枚举区间
                    int l = opt[i][j - 1];
                    int r = opt[i + 1][j];
                    if (l < i) l = i;      // 限制边界
                    if (r >= j) r = j - 1; // 防止越界
                    for (int k = l; k <= r; k++) {
                        int cost = dp[i][k] + dp[k + 1][j] + (s[j] - s[i - 1]);
                        if (cost < dp[i][j]) {
                            dp[i][j] = cost;
                            opt[i][j] = k;
                        }
                    }
                }
            }
            System.out.println(dp[1][n - 1]);
        }
    }

    class len {

        public static void main_len(String[] args) throws IOException {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            String[] s1 = read.readLine().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            n = n + 1;
            int[][] dp = new int[n][n];
            int[] s = new int[n];
            String[] str = read.readLine().split("\\s+");
            for (int i = 1; i < n; i++) {
                s[i] = Integer.parseInt(str[i - 1]);
            }
            for (int i = 1; i < n; i++) {
                s[i] += s[i - 1];
            }
            System.out.println(Arrays.toString(s));
            for (int r = 2; r < n; r++) {  // 枚举规模长度
                System.out.println("规模 " + r + " 时:");
                for (int i = 1; i < n - r + 1; i++) {// 枚举起点
                    int j = i + r - 1;
                    System.out.println("子问题 dp[" + i + "]" + "[" + j + "]");
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) { // 枚举分界点
                        System.out.println("划分点" + "k=" + k + " dp[" + i + "]" + "[" + k + "]" + " + " + "dp[" + (k + 1) + "]" + "[" + j + "]" + " +" + " (s" + "[" + j + "]" + "-" + "s[" + (i - 1) + "])");
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + s[j] - s[i - 1]);
                    }
                }
                System.out.println();
            }
            for (int[] d : dp) {
                System.out.println(Arrays.toString(d));
            }
            System.out.println(dp[1][n - 1]);
        }
    }

    class len_opt {

        public static void main_opt(String[] args) throws IOException {
            int INF = Integer.MAX_VALUE / 2;
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(read.readLine());
            int[] stones = new int[n + 1];
            int[] prefixSum = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];
            int[][] opt = new int[n + 1][n + 1];
            String[] parts = read.readLine().split("\\s+");
            for (int i = 1; i <= n; i++) {
                stones[i] = Integer.parseInt(parts[i - 1]);
                prefixSum[i] = prefixSum[i - 1] + stones[i];
            }
            for (int i = 1; i <= n; i++) {
                dp[i][i] = 0;
                opt[i][i] = i;
            }
            // 区间长度从2开始枚举
            for (int len = 2; len <= n; len++) {
                for (int i = 1; i + len - 1 <= n; i++) {
                    int j = i + len - 1;
                    dp[i][j] = INF;
                    // 四边形不等式优化：opt[i][j-1] <= k <= opt[i+1][j]
                    int left = opt[i][j - 1];
                    int right = opt[i + 1][j];
                    if (left < i) left = i;
                    if (right > j - 1) right = j - 1;
                    for (int k = left; k <= right; k++) {
                        int cost = dp[i][k] + dp[k + 1][j] + prefixSum[j] - prefixSum[i - 1];
                        if (cost < dp[i][j]) {
                            dp[i][j] = cost;
                            opt[i][j] = k;
                        }
                    }
                }
            }
            System.out.println(dp[1][n]);
        }
    }
}
