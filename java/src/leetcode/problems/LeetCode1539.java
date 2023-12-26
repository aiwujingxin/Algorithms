package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 14:52
 */
public class LeetCode1539 {

    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return k - (arr[left - 1] - (left - 1) - 1) + arr[left - 1];
    }
}
