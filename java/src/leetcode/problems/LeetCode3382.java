package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 11/25/25 16:32
 */
public class LeetCode3382 {


    private Set<Integer>[] colSet; // colSet[y] = set of x's at column y
    private List<Integer>[] colList; // colList[y] = sorted list of x's at column y

    public long maxRectangleArea(int[] xCoord, int[] yCoord) {
        int n = xCoord.length;

        // Initialize data structures
        colSet = new HashSet[n];
        colList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            colSet[i] = new HashSet<>();
            colList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int x = xCoord[0], y = yCoord[1];
            colSet[y].add(x);
            colList[y].add(x);
        }

        // Sort all x-lists for efficient processing
        for (int i = 0; i < n; i++) {
            if (!colList[i].isEmpty()) {
                Collections.sort(colList[i]);
            }
        }

        long maxArea = -1;

        // Iterate through all column pairs
        for (int y1 = 0; y1 < n; y1++) {
            if (colSet[y1].isEmpty()) continue;

            Set<Integer> block = new HashSet<>();

            for (int y2 = y1 + 1; y2 < n; y2++) {
                if (colSet[y2].isEmpty()) continue;

                int maxWidth = calculateMaxWidth(y1, y2, block);
                if (maxWidth > 0) {
                    maxArea = Math.max(maxArea, (long) (y2 - y1) * maxWidth);
                }

                block.addAll(colSet[y2]);
            }
        }

        return maxArea;
    }

    private int calculateMaxWidth(int y1, int y2, Set<Integer> block) {
        Set<Integer> commonX = new HashSet<>(colSet[y1]);
        commonX.retainAll(colSet[y2]); // Intersection of x's at y1 and y2

        if (commonX.size() < 2) return -1;

        // Use the list with more points for better efficiency
        List<Integer> sortedX = colList[y1].size() > colList[y2].size()
                ? colList[y1] : colList[y2];

        int maxWidth = -1;

        for (int i = 1; i < sortedX.size(); i++) {
            int x1 = sortedX.get(i - 1);
            int x2 = sortedX.get(i);

            if (!commonX.contains(x1) || !commonX.contains(x2)) continue;

            // Check if any x between x1 and x2 is blocked
            boolean valid = true;
            for (int x = x1; x <= x2; x++) {
                if (block.contains(x)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                maxWidth = Math.max(maxWidth, x2 - x1);
            }
        }

        return maxWidth;
    }
}
