package knowledge.dp.intervaldp;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/10 21:50
 * @description 多边形游戏
 */
public class AcWing283 {

    static int[][] dpMax;
    static int[][] dpMin;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] nums = new int[2 * N + 1];
        char[] ops = new char[2 * N + 1];
        for (int i = 1; i <= N; i++) {
            ops[i] = input.next().charAt(0);
            ops[i + N] = ops[i];
            nums[i] = input.nextInt();
            nums[i + N] = nums[i];
        }
        dpMax = new int[2 * N + 1][2 * N + 1];
        dpMin = new int[2 * N + 1][2 * N + 1];
        for (int i = 1; i <= N; i++) {
            dpMax[i][i] = dpMax[i + N][i + N] = nums[i];
            dpMin[i][i] = dpMin[i + N][i + N] = nums[i];
        }
        for (int len = 2; len <= N; len++) {
            for (int l = 1; l + len - 1 <= 2 * N; l++) {
                int r = l + len - 1;
                dpMax[l][r] = Integer.MIN_VALUE;
                dpMin[l][r] = Integer.MAX_VALUE;
                for (int k = l; k < r; k++) {
                    if (ops[k + 1] == 't') { //加号
                        dpMax[l][r] = Math.max(dpMax[l][r], dpMax[l][k] + dpMax[k + 1][r]);
                        dpMin[l][r] = Math.min(dpMin[l][r], dpMin[l][k] + dpMin[k + 1][r]);
                    } else {
                        dpMax[l][r] = Math.max(dpMax[l][r], getMax(l, k, r));
                        dpMin[l][r] = Math.min(dpMin[l][r], getMin(l, k, r));
                    }
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int l = 1; l <= N; l++) {
            res = Math.max(res, dpMax[l][l + N - 1]);
        }
        System.out.println(res);
        for (int i = 1; i <= N; i++) {
            if (dpMax[i][i + N - 1] == res) {
                System.out.print(i + " ");
            }
        }
    }

    private static int getMin(int l, int mid, int r) {
        int min1 = Math.min(dpMax[l][mid] * dpMax[mid + 1][r], dpMax[l][mid] * dpMin[mid + 1][r]);
        int min2 = Math.min(dpMin[l][mid] * dpMax[mid + 1][r], dpMin[l][mid] * dpMin[mid + 1][r]);
        return Math.min(min1, min2);
    }

    private static int getMax(int l, int mid, int r) {
        int max1 = Math.max(dpMax[l][mid] * dpMax[mid + 1][r], dpMax[l][mid] * dpMin[mid + 1][r]);
        int max2 = Math.max(dpMin[l][mid] * dpMax[mid + 1][r], dpMin[l][mid] * dpMin[mid + 1][r]);
        return Math.max(max1, max2);
    }
}
