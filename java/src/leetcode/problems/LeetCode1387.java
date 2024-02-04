package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 16:13
 */
public class LeetCode1387 {

    public int getKth(int lo, int hi, int k) {
        int n = hi - lo + 1;
        int[][] arr = new int[n][];
        for (int i = lo; i <= hi; i++) {
            arr[i - lo] = new int[]{cal(i), i};
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        return arr[k - 1][1];
    }

    private int cal(Integer n) {
        int cnt = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            cnt++;
        }
        return cnt;
    }
}
