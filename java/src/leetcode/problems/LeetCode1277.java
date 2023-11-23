package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/21 21:25
 */
public class LeetCode1277 {

    public int countSquares(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length, columns = matrix[0].length;

        int[][] dp = new int[rows][columns];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    map.put(1, map.getOrDefault(1, 0) + 1);
                    //初始化
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        //子父问题，转移方程
                        int side = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);

                        dp[i][j] = side + 1;

                        if (dp[i][j] == 1) {
                            continue;
                        }

                        int temp = dp[i][j];
                        while (temp > 1) {
                            map.put(temp, map.getOrDefault(temp, 0) + 1);
                            temp--;

                        }
                    }
                }
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            res += entry.getValue();
        }
        return res;
    }
}
