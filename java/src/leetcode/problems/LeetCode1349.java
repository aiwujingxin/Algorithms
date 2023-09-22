package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/20 00:04
 */
public class LeetCode1349 {

    //https://leetcode.cn/problems/maximum-students-taking-exam/solution/by-ezhy4yy4xv-1vit/

    //存放奇数列'.'
    List<Integer> ls0 = new ArrayList<>();
    //存放偶数列'.'
    List<Integer> ls1 = new ArrayList<>();
    int m, n;
    boolean[] visit;
    int[] match;
    int[][] data;
    int[] dy = {1, 1, 1, -1, -1, -1};
    int[] dx = {0, 1, -1, 0, 1, -1};

    int getPosition(int x, int y) {
        return x * n + y + 1;
    }

    public int maxStudents(char[][] seats) {
        m = seats.length;
        n = seats[0].length;
        //计算有多少个'.'
        int count = 0;
        data = new int[m * n + 1][m * n + 1];
        match = new int[m * n + 1];
        visit = new boolean[m * n + 1];
        //按列遍历
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (seats[i][j] != '.') {
                    continue;
                }
                count++;
                //偶数列
                int cur = getPosition(i, j);
                if ((j & 1) == 0) {
                    ls0.add(cur);
                    //6个方向关联
                    for (int k = 0; k < 6; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < m && y >= 0 && y < n && seats[x][y] == '.') {
                            data[cur][getPosition(x, y)] = 1;
                        }
                    }
                    //奇数行
                } else {
                    ls1.add(cur);
                }
            }
        }
        int res = 0;
        for (Integer integer : ls0) {
            res += dfs(integer);
            Arrays.fill(visit, false);
        }
        return count - res;
    }

    //匈牙利算法
    int dfs(int x) {
        for (int y : ls1) {
            if (data[x][y] != 0 && !visit[y]) {
                visit[y] = true;
                if (match[y] == 0 || dfs(match[y]) == 1) {
                    match[y] = x;
                    return 1;
                }
            }
        }
        return 0;
    }
}
