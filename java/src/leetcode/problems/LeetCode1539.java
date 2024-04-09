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
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] - mid - 1 < k) l = mid + 1;
            else r = mid;
        }
        return k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1];
    }
}
