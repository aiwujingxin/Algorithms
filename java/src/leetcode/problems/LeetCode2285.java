package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/31 13:38
 */
public class LeetCode2285 {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        long sum = 0;
        int index = 1;
        for (int i = 0; i < degree.length; i++) {
            sum += (long) degree[i] * index;
            index++;
        }
        return sum;
    }
}
