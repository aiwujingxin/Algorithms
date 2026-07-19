package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 6/21/26 14:34
 * @description 逆序思维
 */
public class LeetCode2718 {

    public long matrixSumQueries(int n, int[][] queries) {
        // 记录行和列是否已经被访问过（被后面的操作覆盖）
        boolean[] rowVisited = new boolean[n];
        boolean[] colVisited = new boolean[n];

        // 记录已经访问过的行数和列数
        int rowCount = 0;
        int colCount = 0;

        long totalSum = 0;

        // 倒序遍历查询
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int index = queries[i][1];
            int val = queries[i][2];

            if (type == 0) { // 修改行
                if (!rowVisited[index]) {
                    // 这一行中，还没有被列操作覆盖的元素个数为 (n - colCount)
                    totalSum += (long) val * (n - colCount);
                    rowVisited[index] = true;
                    rowCount++;
                }
            } else { // 修改列
                if (!colVisited[index]) {
                    // 这一列中，还没有被行操作覆盖的元素个数为 (n - rowCount)
                    totalSum += (long) val * (n - rowCount);
                    colVisited[index] = true;
                    colCount++;
                }
            }

            // 优化：如果所有行或所有列都已经被覆盖，可以提前结束
            if (rowCount == n || colCount == n) {
                break;
            }
        }

        return totalSum;
    }
}
