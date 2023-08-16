package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/13 23:18
 */
public class LeetCode978 {

    public int maxTurbulenceSize(int[] arr) {
        int left = 0;
        int right = 0;
        int ans = 1;
        while (right < arr.length - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
