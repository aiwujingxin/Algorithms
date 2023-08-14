package basic.algorithm.dp.interval;

import leetcode.problems.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/10 21:44
 * <a href="https://www.acwing.com/problem/content/description/284/"></a>
 * <p>
 * <a href="https://www.acwing.com/blog/content/4802/"></a>
 * <a href="https://leetcode.cn/circle/article/BO520a/"></a>
 * {@link LeetCode1000_dp_3d}
 * {@link LeetCode312_dp 戳气球}
 * {@link LeetCode486_dp}
 * {@link LeetCode516}
 * {@link LeetCode647_dp_2d}
 * {@link LeetCode678_dp}
 */
public class AcWing282 {

    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s1 = read.readLine().split("\\s+");
        int n = Integer.parseInt(s1[0]);
        int[][] f = new int[n + 1][n + 1];
        int[] s = new int[n + 1];
        String[] str = read.readLine().split("\\s+");
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(str[i - 1]);
        }
        for (int i = 1; i <= n; i++) {
            s[i] += s[i - 1];
        }
        // 区间长度来枚举
        for (int len = 2; len <= n; len++) {
            // 枚举起点
            for (int i = 1; i + len - 1 <= n; i++) {
                int l = i;
                int r = i + len - 1;
                f[l][r] = Integer.MAX_VALUE;
                // 枚举分界点
                for (int k = l; k < r; k++) {
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
                }

            }
        }
        System.out.println(f[1][n]);
    }
}

