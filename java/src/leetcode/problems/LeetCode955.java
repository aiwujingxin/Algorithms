package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 13:44
 */
public class LeetCode955 {

    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int deleteCount = 0;

        // sortedRows[i] 表示 strs[i] 和 strs[i+1] 是否已经处于严格递增状态
        // 如果是，后续的列就不需要再比较这两行了
        boolean[] sortedRows = new boolean[n - 1];

        // 遍历每一列
        for (int col = 0; col < m; col++) {
            boolean shouldDelete = false;

            // 检查当前列是否会导致乱序
            for (int i = 0; i < n - 1; i++) {
                // 如果这两行之前还没确定顺序，且当前列出现了逆序
                if (!sortedRows[i] && strs[i].charAt(col) > strs[i + 1].charAt(col)) {
                    shouldDelete = true;
                    break;
                }
            }

            if (shouldDelete) {
                // 如果需要删除，计数+1，且不更新 sortedRows 状态
                deleteCount++;
            } else {
                // 如果保留这一列，更新 sortedRows 状态
                for (int i = 0; i < n - 1; i++) {
                    if (!sortedRows[i] && strs[i].charAt(col) < strs[i + 1].charAt(col)) {
                        sortedRows[i] = true;
                    }
                }
            }
        }

        return deleteCount;
    }

}
