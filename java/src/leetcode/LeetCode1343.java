package leetcode;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 22:01
 */
public class LeetCode1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        System.out.println(Arrays.toString(sum));
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < arr.length) {
            while (right - left + 1 > k) {
                left++;
            }
            if (right - left + 1 == k) {
                int l = left == 0 ? 0 : sum[left - 1];
                int t = (sum[right] - l) / (right - left + 1);
                if (t >= threshold) {
                    count++;
                }
            }
            right++;
        }
        return count;
    }

}
