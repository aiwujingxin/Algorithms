package knowledge.datastructure.graph.connectivity.impl;

import knowledge.datastructure.graph.connectivity.Connectivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 13:45
 * @description Tarjan 查找有向图的强连通分量
 * @link <a href="https://www.bilibili.com/video/BV1SY411M7Tv/?spm_id_from=333.880.my_history.page.click&vd_source=88e5a3e60377510439e11f13b5878c25"></a>
 */
public class Tarjan implements Connectivity {

    // 图
    private List<Integer>[] graph;
    // 访问
    private int[] dfn, low;
    private int time; // 时间戳
    // 栈
    private boolean[] instk;
    private Stack<Integer> stack;
    // result
    private List<List<Integer>> sccList; // 强连通分量
    private int[] scc;
    private int[] size; //结点 i 所在 SCC 的编号; 强连通 i 的大小
    private int sc; // 强连通分量个数

    public List<List<Integer>> findSCC(int n, List<Integer>[] graph) {
        this.graph = graph;
        this.scc = new int[n];
        this.size = new int[n];
        this.dfn = new int[n];
        this.low = new int[n];
        this.instk = new boolean[n];
        this.stack = new Stack<>();
        this.sccList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfn[i] == 0) {
                tarjan(i);
            }
        }
        return sccList;
    }

    private void tarjan(int x) {
        stack.push(x);
        instk[x] = true;
        dfn[x] = low[x] = ++time;
        for (int y : graph[x]) {
            if (dfn[y] == 0) {
                tarjan(y);
                low[x] = Math.min(low[x], low[y]);
            } else if (instk[y]) {
                low[x] = Math.min(low[x], dfn[y]);
            }
        }
        if (dfn[x] == low[x]) {
            sc++;
            int node;
            List<Integer> c = new ArrayList<>();
            do {
                node = stack.pop();
                instk[node] = false;
                c.add(node);
                scc[node] = sc;
                size[sc]++;
            } while (node != x);
            sccList.add(c);
        }
    }
}
