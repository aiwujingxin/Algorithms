package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 6/8/26 22:48
 */
public class LeetCode2161 {

    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], i};
        }
        Arrays.sort(arr, (o1, o2) -> {
            int c1 = o1[0] < pivot ? 0 : (o1[0] == pivot ? 1 : 2);
            int c2 = o2[0] < pivot ? 0 : (o2[0] == pivot ? 1 : 2);
            if (c1 != c2) {
                return c1 - c2;        // 按类别排序
            } else {
                return o1[1] - o2[1];  // 同类按原索引排序
            }
        });
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i][0];
        }
        return nums;
    }
}
