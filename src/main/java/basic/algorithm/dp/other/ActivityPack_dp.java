package basic.algorithm.dp.other;

import basic.problems.dp.ActivityPack;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/3 11:31
 */
public class ActivityPack_dp implements ActivityPack {

    //https://www.cs.princeton.edu/~wayne/cs423/lectures/dynamic-programming-4up.pdf

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
        int res = selector_DP_memorized_helper(s, f, c.length - 1, c);
        //System.out.println(Arrays.toString(c));
        printSolution(c);
        return res;
    }

    private static int selector_DP_memorized_helper(int[] s, int[] f, int end, int[] c) {
        if (end == 0) {
            c[end] = 0;
        } else {
            int left = 0;
            if (c[end] == Integer.MIN_VALUE) {
                //find the biggest compatible index j, where j < end, assign to left.
                for (int i = end - 1; i >= 0; i--) {
                    if (f[i] <= s[end]) {
                        left = i;
                        break;
                    }
                }
                //in case index end is in optimal set.
                //选end
                int temp1 = selector_DP_memorized_helper(s, f, left, c) + 1;
                //in case index end is NOT in optimal set.
                // 不选end
                int temp2 = selector_DP_memorized_helper(s, f, end - 1, c);
                c[end] = Math.max(temp1, temp2);
                //System.out.println("c " + end + "=" + c[end] + " " + temp1 + " " + temp2);
            }
        }
        return c[end];
    }

    private static void printSolution(int[] c) {
        StringBuilder solution = new StringBuilder();
        for (int i = 1; i < c.length; i++) {
            if (c[i] > c[i - 1]) {
                if (solution.length() != 0) solution.append(",");
                solution.append(i);
            }
        }
        System.out.println("Max compatibile solution DP memorized: " + solution);
    }
}
