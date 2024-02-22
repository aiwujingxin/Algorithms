package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/31 13:29
 */
public class LeetCode2191 {

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], convert(mapping, nums[i])};
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        int[] res = new int[n];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i][0];
        }
        return res;
    }

    private int convert(int[] mapping, int num) {
        int res = 0;
        String t = String.valueOf(num);
        int base = 1;
        for (int i = t.length() - 1; i >= 0; i--) {
            res += mapping[t.charAt(i) - '0'] * base;
            base = base * 10;
        }
        return res;


    }
}
