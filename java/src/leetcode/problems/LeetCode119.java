package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 16:22
 */
public class LeetCode119 {

    public List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        Arrays.fill(row, 0);
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            // 关键点：从后往前加，避免旧值被覆盖
            for (int j = i; j >= 1; j--) {
                row[j] += row[j - 1];
            }
        }
        return Arrays.asList(row);
    }

    // C(n,k)=C(n,k−1)×(n−k+1)/k
    public List<Integer> getRow_(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long val = 1;
        for (int k = 0; k <= rowIndex; k++) {
            row.add((int) val);
            val = val * (rowIndex - k) / (k + 1);
        }
        return row;
    }
}
