package basic.algorithm.dp.tree;

import java.io.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/10 06:17
 * <a href="https://www.acwing.com/solution/content/106038/"></a>
 */
public class AcWing287 {
    private static final int N = 200010, M = 2 * N;
    private static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M], deg = new int[N];
    //up[i]和down[i]分别表示以节点i为根节点，向上和向下的最大流量
    private static int[] up = new int[N], down = new int[N];
    private static int n, idx = 0;

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            idx = 0;
            for (int i = 0; i < N; i++) {
                deg[i] = up[i] = down[i] = 0;
                h[i] = -1;
            }
            n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n - 1; i++) {
                String[] ss = reader.readLine().split(" ");
                int a = Integer.parseInt(ss[0]), b = Integer.parseInt(ss[1]), c = Integer.parseInt(ss[2]);
                add(a, b, c);
                add(b, a, c);
            }
            dfsDown(1, -1);
            dfsUp(1, -1);
            int ans = 0;
            for (int i = 1; i <= n; i++) ans = Math.max(ans, up[i] + down[i]);
            writer.write(ans + "\n");
        }
        writer.flush();
    }

    private static void dfsUp(int u, int parent) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == parent) continue;
            //如果u的度数为1，v的up只有这一条边唯一确定；否则对于当前的u可能有多个出边，不止v一个，计算up[v]时需要减去对v的贡献从而得到u的需求量，
            //如果需求量大于了w[i]，说明如果以v为源点，最多只能供应w[i]
            if (deg[u] == 1) up[v] = w[i];
            else up[v] = Math.min(up[u] + down[u] - Math.min(down[v], w[i]), w[i]);
            dfsUp(v, u);
        }
    }

    private static void dfsDown(int u, int parent) {
        down[u] = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == parent) continue;
            dfsDown(v, u);
            //如果v节点的度数为1，v就是汇点，直接加上这条支路；如果v的度数不是1，此时的v不是汇点，v也有down[v]（向下的贡献），
            //如果down[v]大于了能给v供给的最大w[i]，就只能取w[i]
            if (deg[v] == 1) down[u] += w[i];
            else down[u] += Math.min(down[v], w[i]);
        }
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx;
        w[idx++] = c;
        deg[b]++;
    }
}
