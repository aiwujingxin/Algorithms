package knowledge.algorithms.dp.intervaldp.problems;

import java.io.*;
import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/10 21:44
 * @description 石子合并
 * @link <a href="https://www.acwing.com/problem/content/284/"></a>
 * @example
 * input
 * 4
 * 1 3 5 2
 * output
 * 22
 */
public class AcWing282 {

    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
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
