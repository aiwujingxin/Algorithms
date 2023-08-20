package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/17 15:59
 */
public class LeetCode980_v2 {

    //https://leetcode.com/problems/unique-paths-iii/discuss/2218494/Simple-java-solution-or-easy-to-understand-or-faster-than-35-or-with-explanation
    int count = 0;
    int MAX_ELEMENT = 0;
    int obstacle = 0;

    public int uniquePathsIII(int[][] grid) {
        MAX_ELEMENT = grid.length * grid[0].length; // get total no. of cells

        // finding total no. of obstacle
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) obstacle++;
            }
        }
        // find the cell with starting point and start from there
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) { // 1 is the starting point for the robot
                    solve(grid, i, j, new ArrayList<Integer>());
                    return count;
                }

            }
        }
        return count;
    }

    public void solve(int[][] grid, int i, int j, List<Integer> list) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 ||
                grid[i][j] == Integer.MIN_VALUE) {
            return;
        }
        // if cell with value 2 is reached then find out if
        // all the cell are visited or not

        if (grid[i][j] == 2) {
            // since obstacle are not be visited
            //MAX_ELEMENT-1 is all the other cells and -1 is for one cell that has value as 2 i.e ending cell
            if (list.size() == MAX_ELEMENT - 1 - obstacle) {
                count++;
            }
            return;
        }

        int temp = grid[i][j];
        list.add(grid[i][j]);//visit cell
        grid[i][j] = Integer.MIN_VALUE; // since this cell is visited , hence mark it so that same cell can't be visited again

        //now we have choice to move up,down,left and right
        //up
        solve(grid, i - 1, j, list);
        //down
        solve(grid, i + 1, j, list);
        //left
        solve(grid, i, j - 1, list);
        //right
        solve(grid, i, j + 1, list);
        grid[i][j] = temp; //restore the original value as this call stack is ending
        list.remove(list.size() - 1); // remove last inserted value as we are backtracking

    }
}
