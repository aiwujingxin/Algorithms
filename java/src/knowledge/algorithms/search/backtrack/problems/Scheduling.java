package knowledge.algorithms.search.backtrack.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/31 23:25
 * @description 批处理作业调度 排列树
 */
public class Scheduling {

    public static void main(String[] args) {
        new Scheduling().Schedule(new int[][]{{2, 1}, {3, 1}, {2, 3}});
        System.out.print(Arrays.toString(bestx));
        System.out.println(bestf);
    }

    int[] x;
    int[][] m;
    int f1, f, n;
    static int bestf = Integer.MAX_VALUE;
    static int[] bestx;
    int[] f2;


    public void Schedule(int[][] m) {
        this.m = m;
        this.n = m.length;
        this.x = new int[n];
        this.f2 = new int[n];
        bestx = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = i;
        }
        backtrack(0);
    }

    public void backtrack(int i) {
        if (i == n) {
            for (int k = 0; k < n; k++) {
                bestx[k] = x[k];
            }
            bestf = f;
        } else {
            for (int j = i; j < n; j++) {
                f1 += m[x[j]][0];
                f2[i] = ((i > 0 && f2[i - 1] > f1) ? f2[i - 1] : f1) + m[x[j]][1];
                f += f2[i];
                if (f < bestf) {
                    swap(x, i, j);
                    backtrack(i + 1);
                    swap(x, i, j);
                }
                // 恢复全局状态
                f1 -= m[x[j]][0];
                f -= f2[i];
            }
        }
    }

    public void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
}
