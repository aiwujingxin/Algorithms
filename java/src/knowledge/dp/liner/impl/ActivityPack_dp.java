package knowledge.dp.liner.impl;


import knowledge.dp.liner.ActivityPack;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/3 11:31
 */
public class ActivityPack_dp implements ActivityPack {

    @Override
    public int activityPack(int[][] periods) {
        int[] s = new int[periods.length];
        for (int i = 0; i < periods.length; i++) {
            s[i] = periods[i][0];
        }
        int[] f = new int[periods.length];
        for (int i = 0; i < periods.length; i++) {
            f[i] = periods[i][1];
        }
        return selector_DP_memorized(s, f);
    }

    /**
     * dynamic programming ActivitySelector - UpBottom memorized. 16.1-1
     *
     * @param s 活动开始时间
     * @param f 活动结束时间
     */
    public static int selector_DP_memorized(int[] s, int[] f) {
        int[] c = new int[s.length];
        Arrays.fill(c, Integer.MIN_VALUE);
        int res = dfs(s, f, c.length - 1, c);
        printSolution(c);
        return res;
    }

    private static int dfs(int[] s, int[] f, int end, int[] c) {
        if (end == 0) {
            c[end] = 0;
            return c[end];
        }
        int left = 0;
        if (c[end] == Integer.MIN_VALUE) {
            //find the biggest compatible index j, where j < end, assign to left.
            for (int i = end - 1; i >= 0; i--) {
                if (f[i] <= s[end]) {
                    left = i;
                    break;
                }
            }
            int temp1 = dfs(s, f, left, c) + 1;
            int temp2 = dfs(s, f, end - 1, c);
            c[end] = Math.max(temp1, temp2);
        }
        return c[end];
    }

    private static void printSolution(int[] c) {
        StringBuilder solution = new StringBuilder();
        for (int i = 1; i < c.length; i++) {
            if (c[i] > c[i - 1]) {
                if (!solution.isEmpty()) {
                    solution.append(",");
                }
                solution.append(i);
            }
        }
        System.out.println("Max compatibile solution DP memorized: " + solution);
    }
}
