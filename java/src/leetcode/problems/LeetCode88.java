package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 11:24
 */
public class LeetCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m >= 1 && n >= 1) {
            int i = m + n - 1;
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
        while (m >= 1) {
            int i = m + n - 1;
            nums1[i] = nums1[m - 1];
            m--;
        }
        while (n >= 1) {
            int i = m + n - 1;
            nums1[i] = nums2[n - 1];
            n--;
        }
    }
}
