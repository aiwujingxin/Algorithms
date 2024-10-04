package knowledge.algorithms.dp.optimizedp.problems;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/10/4 14:30
 * @description 制定区间+1,求最长不下降子序列长度
 * @link <a href="https://www.luogu.com.cn/problem/P3287"></a>
 */

public class CornField {

    public static int MAXN = 10001;

    public static int MAXK = 501;

    public static int MAXH = 5500;

    public static int[] arr = new int[MAXN];

    public static int[][] tree = new int[MAXH + 1][MAXK + 1];

    public static int n, k;

    public static void update(int x, int y, int v) {
        for (int i = x; i <= MAXH; i += i & -i) {
            for (int j = y; j <= k + 1; j += j & -j) {
                tree[i][j] = Math.max(tree[i][j], v);
            }
        }
    }

    public static int max(int x, int y) {
        int ans = 0;
        for (int i = x; i > 0; i -= i & -i) {
            for (int j = y; j > 0; j -= j & -j) {
                ans = Math.max(ans, tree[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        k = (int) in.nval;
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        out.println(compute());
        out.flush();
        out.close();
        br.close();
    }

    public static int compute() {
        // 注意这里第二层for循环，j一定是从k~0的枚举
        // 课上进行了重点图解，防止同一个i产生的记录之间相互影响
        int v, dp;
        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= 0; j--) {
                v = arr[i] + j;
                // 修改次数j，树状数组中对应的下标是j+1
                dp = max(v, j + 1) + 1;
                update(v, j + 1, dp);
            }
        }
        // 修改次数k，树状数组中对应的下标是k+1
        return max(MAXH, k + 1);
    }

}