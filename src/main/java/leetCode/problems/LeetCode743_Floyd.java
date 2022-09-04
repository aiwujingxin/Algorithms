package leetCode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 16:58
 */
public class LeetCode743_Floyd {

    public int networkDelayTime_FW(int[][] times, int N, int K) {
        double[][] disTo = new double[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(disTo[i], Double.POSITIVE_INFINITY);
        }
        for (int i = 0; i < N; i++) {
            disTo[i][i] = 0;
        }
        for (int[] edge : times) {
            disTo[edge[0] - 1][edge[1] - 1] = edge[2];
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (disTo[i][j] > disTo[i][k] + disTo[k][j]) {
                        disTo[i][j] = disTo[i][k] + disTo[k][j];
                    }

                }
            }
        }
        double max = Double.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (disTo[K - 1][i] == Double.POSITIVE_INFINITY) {
                return -1;
            }
            max = Math.max(max, disTo[K - 1][i]);
        }
        return (int) max;
    }
}
