package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/21 20:56
 */
public class LeetCode1462_Floyd {

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] connected = new boolean[n][n];
        for (int[] p : prerequisites) {
            connected[p[0]][p[1]] = true; // p[0] -> p[1]
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    connected[i][j] = connected[i][j] || connected[i][k] && connected[k][j];
                }
            }

        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            ans.add(connected[q[0]][q[1]]);
        }
        return ans;
    }
}
