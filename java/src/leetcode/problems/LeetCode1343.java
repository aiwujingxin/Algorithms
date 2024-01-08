package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 22:01
 */
public class LeetCode1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int[] presum = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            presum[i] = presum[i - 1] + arr[i - 1];
        }
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < arr.length) {
            while (right - left + 1 > k) {
                left++;
            }
            if (right - left + 1 == k) {
                int l = presum[left];
                int t = (presum[right + 1] - l) / (right - left + 1);
                if (t >= threshold) {
                    count++;
                }
            }
            right++;
        }
        return count;
    }

}
