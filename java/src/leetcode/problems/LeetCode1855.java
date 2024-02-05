package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/5 12:53
 */
public class LeetCode1855 {

    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            int left = 0;
            int right = nums2.length - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (nums2[mid] < nums1[i]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            if (nums1[i] <= nums2[left] && i <= left) {
                res = Math.max(res, left - i);
            }
        }
        return res;
    }
}
