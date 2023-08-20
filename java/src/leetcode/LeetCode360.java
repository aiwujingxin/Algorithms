package leetcode;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/17 16:58
 */
public class LeetCode360 {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = a * nums[i] * nums[i] + b * nums[i] + c;
        }
        Arrays.sort(res);
        return res;
    }


    //===opt===
    public int[] sortTransformedArray_opt(int[] nums, int a, int b, int c) {
        return a == 0 ? sortLinearFunction(nums, b, c) : sortQuadraticFunction(nums, a, b, c);
    }

    public int[] sortLinearFunction(int[] nums, int b, int c) {
        int length = nums.length;
        int[] transformed = new int[length];
        int start = b >= 0 ? 0 : length - 1;
        int direction = b >= 0 ? 1 : -1;
        for (int i = 0, j = start; i < length; i++, j += direction) {
            transformed[j] = b * nums[i] + c;
        }
        return transformed;
    }

    public int[] sortQuadraticFunction(int[] nums, int a, int b, int c) {
        int length = nums.length;
        int[] transformed = new int[length];
        int start = a < 0 ? 0 : length - 1;
        int direction = a < 0 ? 1 : -1;
        //对称轴
        double symmetryAxis = -b / (2.0 * a);
        int index1 = 0, index2 = length - 1;
        for (int i = 0, j = start; i < length; i++, j += direction) {
            if (Math.abs(nums[index1] - symmetryAxis) > Math.abs(nums[index2] - symmetryAxis)) {
                transformed[j] = a * nums[index1] * nums[index1] + b * nums[index1] + c;
                index1++;
            } else {
                transformed[j] = a * nums[index2] * nums[index2] + b * nums[index2] + c;
                index2--;
            }
        }
        return transformed;
    }
}

