package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/7 18:03
 */
public class LeetCode2285 {
    //排序不等式
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];
        for (int[] road : roads) {
            degree[road[0]] += 1;
            degree[road[1]] += 1;
        }
        Arrays.sort(degree);
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += degree[i - 1] * i;
        }
        return sum;
    }
}
