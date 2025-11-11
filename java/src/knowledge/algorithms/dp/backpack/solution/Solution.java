package knowledge.algorithms.dp.backpack.solution;

/**
 * @author wujingxinit@outlook.com
 * @date 11/5/25 05:09
 * @description DP输出方案
 */
public interface Solution {

    /*
     *<DP>
     * for i in range(1, n):
     *   for j in range(1, m):
     *     dp[i][j] = best_of(possible_moves)
     *     from[i][j] = argmax_or_argmin(possible_moves)
     *<回溯路径>
     * path = []
     * (i, j) = (n, m)
     * while (i, j) != (0, 0):
     *   path.append((i, j))
     *   (i, j) = from[i][j]
     * reverse(path)
     */

}
