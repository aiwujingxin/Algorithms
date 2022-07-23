package LeetCode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/17 15:54
 */
public class LeetCode980 {

    public int uniquePathsIII(int[][] grid) {
        int count = 0;      // count for empty spaces

        int sr = 0;         // start row
        int sc = 0;         // start column

        int er = 0;         // end row
        int ec = 0;         // end column

        // loop to find all above things
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                } else if (grid[i][j] == 2) {
                    er = i;
                    ec = j;
                } else if (grid[i][j] == 0) {
                    count++;
                }
            }
        }

        return solution(sr, sc, er, ec, count + 1, grid);
    }

    public int solution(int i, int j, int er, int ec, int count, int[][] grid) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == -1) {
            return 0;
        }

        if (i == er && j == ec) {
            if (count == 0) {     // all empty columns are traversed
                return 1;
            } else {              // all empty columns are not traversed
                return 0;
            }
        }

        grid[i][j] = -1;

        // call and getting answer from all 4 directions
        int paths = solution(i - 1, j, er, ec, count - 1, grid) +
                solution(i, j - 1, er, ec, count - 1, grid) +
                solution(i + 1, j, er, ec, count - 1, grid) +
                solution(i, j + 1, er, ec, count - 1, grid);

        grid[i][j] = 0;

        return paths;
    }
}
