package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 6/20/26 12:51
 */
public class LeetCode1706 {

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int c = i;
            for (int[] row : grid) {
                int next_c = c + row[c];
                // 如果撞到左右墙壁，或者相邻挡板形成了 "V" 型（方向不一致），则卡住
                if (next_c < 0 || next_c >= n || row[c] != row[next_c]) {
                    c = -1;
                    break;
                }
                c = next_c;
            }
            ans[i] = c;
        }
        return ans;
    }
}
