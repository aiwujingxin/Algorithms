package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/5 12:53
 */
public class LeetCode1855 {

    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            int l = 0;
            int r = nums2.length - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (nums2[mid] < nums1[i]) r = mid - 1;
                else l = mid;
            }
            if (nums1[i] <= nums2[l] && i <= l) {
                res = Math.max(res, l - i);
            }
        }
        return res;
    }
}
