package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 11/25/25 15:36
 */
public class LeetCode3380 {

    HashSet<Integer>[] colRowSet;
    HashSet<Integer>[] rowColSet;
    List<Integer>[] colRowList;
    List<Integer>[] rowColList;

    public int maxRectangleArea(int[][] points) {
        int n = 101;
        Arrays.sort(points, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));
        colRowSet = new HashSet[n];
        rowColSet = new HashSet[n];
        colRowList = new List[n];
        rowColList = new List[n];
        for (int i = 0; i < 101; i++) {
            colRowSet[i] = new HashSet<>();
            colRowList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            rowColSet[i] = new HashSet<>();
            colRowList[i] = new ArrayList<>();
        }
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            colRowSet[y].add(x);
            colRowList[y].add(x);

            rowColSet[x].add(y);
            rowColList[x].add(y);
        }
        for (int i = 0; i < n; i++) {
            if (!colRowSet[i].isEmpty()) System.out.println(" i " + i + " set " + colRowSet[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> block = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                HashSet<Integer> rows2 = colRowSet[j];
                int max = cal(i, j, block);
                block.addAll(rows2);
                ans = Math.max((j - i) * max, ans);
            }
        }
        return ans;
    }

    private int cal(int c1, int c2, Set<Integer> block) {
        HashSet<Integer> row1 = colRowSet[c1];
        HashSet<Integer> row2 = colRowSet[c2];
        if (row1.size() <= 1 || row2.size() <= 1) {
            return -1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int r1 : row1) {
            if (row2.contains(r1)) {
                set.add(r1);
            }
        }
        if (set.size() <= 1) return -1;
        int max = -1;
        List<Integer> list = colRowList[c1].size() >= colRowList[c2].size() ? colRowList[c1] : colRowList[c2];
        for (int i = 1; i < list.size(); i++) {
            if (!set.contains(list.get(i - 1)) || !set.contains(list.get(i))) {
                continue;
            }
            boolean can = true;
            for (int k = list.get(i - 1); k <= list.get(i); k++) {
                if (block.contains(k)) {
                    can = false;
                    break;
                }
            }
            if (can) {
                max = Math.max(max, list.get(i) - list.get(i - 1));
            }
        }
        return max;
    }
}
