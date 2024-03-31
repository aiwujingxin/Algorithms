package knowledge.algorithms.search.backtrack.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/31 22:50
 * @description 装载问题 子集树
 * 有n个集装箱要装上2艘载重量分别为c1和c2的轮船，其中集装箱i的重量为wi，且∑wi <= c1 + c2。
 * 问是否有一个合理的装载方案,可将这n个集装箱装上这2艘轮船。如果有，找出一种装载方案。
 */
public class Loading {

    public static void main(String[] args) {
        System.out.println(new Loading().Loading(new int[]{10, 40, 40}, 50, 50));
        System.out.println(Arrays.toString(bastX));
        System.out.println(new Loading().Loading(new int[]{30, 30, 30, 50, 50, 60}, 100, 150));
        System.out.println(Arrays.toString(bastX));
    }

    int bastW = 0;
    static int[] bastX;
    int n;
    int r;

    public int Loading(int[] w, int c1, int c2) {
        n = w.length;
        bastX = new int[n];
        for (int j : w) {
            r += j;
        }
        backtrack(w, 0, new int[n], c1, c2, 0);
        return bastW;
    }

    private void backtrack(int[] w, int i, int[] x, int c1, int c2, int cw) {
        if (i == n) {
            if (cw > bastW) {
                for (int j = 0; j < n; j++) {
                    bastX[j] = x[j];
                }
                bastW = cw;
            }
            return;
        }
        r -= w[i];
        // 约束函数
        if (cw + w[i] <= c1) {
            x[i] = 1;
            cw += w[i];
            backtrack(w, i + 1, x, c1, c2, cw);
            cw -= w[i];
            x[i] = 0;
        }

        // 限界函数
        if (cw + r > bastW) {
            x[i] = 0;
            backtrack(w, i + 1, x, c1, c2, cw);
        }
        r += w[i];
    }
}
