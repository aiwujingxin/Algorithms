package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 12/11/25 21:39
 */
public class LeetCode3531 {

    public int countCoveredBuildings(int n, int[][] buildings) {
        Arrays.sort(buildings, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));
        HashMap<Integer, List<Integer>> rowCols = new HashMap<>();
        HashMap<Integer, List<Integer>> colRows = new HashMap<>();
        for (int[] b : buildings) {
            rowCols.computeIfAbsent(b[0], k -> new ArrayList<>()).add(b[1]);
            colRows.computeIfAbsent(b[1], k -> new ArrayList<>()).add(b[1]);
        }
        int cnt = 0;
        for (int[] b : buildings) {
            int row = b[0];
            int col = b[1];
            List<Integer> cols = rowCols.get(row);
            List<Integer> rows = colRows.get(col);
            int cIdx = find(cols, col);
            if (cIdx == 0 || cIdx == cols.size() - 1) continue;
            int rIdx = find(rows, row);
            if (rIdx == 0 || rIdx == rows.size() - 1) continue;
            cnt++;
        }
        return cnt;
    }

    int find(List<Integer> a, int x) {
        int l = 0;
        int r = a.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a.get(mid) == x) return mid;
            if (a.get(mid) < x) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
