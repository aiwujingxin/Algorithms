package leetplan.graph.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/22 23:41
 */
public class LeetCode1615 {

    //https://leetcode.com/problems/maximal-network-rank/discuss/888916/Java-simple-O(n2)

    //统计与各个城市连接的道路数，最后的结果就是最大的那两个值和，如果这两个城市之间有连接的话，需要-1
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] cnts = new int[n];
        for (int[] r : roads) {
            cnts[r[0]]++;
            cnts[r[1]]++;
            connected[r[0]][r[1]] = true;
            connected[r[1]][r[0]] = true;  // cache if i and j directly connected
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, cnts[i] + cnts[j] - (connected[i][j] ? 1 : 0));  // loop all pairs
            }
        }
        return res;
    }
}
