package leetcode.problems;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/6 13:29
 */
public class LeetCode2865 {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long max = 0;
        int n = maxHeights.size();
        for (int i = 0; i < n; i++) {
            long left = getLeft(maxHeights, i);
            long right = getRight(maxHeights, i);
            max = Math.max(max, left + right + maxHeights.get(i));
        }
        return max;
    }

    private long getLeft(List<Integer> maxHeights, int index) {
        long sum = 0;
        int max = maxHeights.get(index);
        for (int j = index - 1; j >= 0; j--) {
            max = Math.min(maxHeights.get(j), max);
            sum += max;
        }
        return sum;
    }

    private long getRight(List<Integer> maxHeights, int index) {
        long sum = 0;
        int max = maxHeights.get(index);
        for (int j = index + 1; j < maxHeights.size(); j++) {
            max = Math.min(maxHeights.get(j), max);
            sum += max;
        }
        return sum;
    }
}
