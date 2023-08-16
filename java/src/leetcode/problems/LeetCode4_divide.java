package leetcode.problems;


/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/13 00:17
 */
public class LeetCode4_divide {

    //https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/1782376/Java-or-1ms-or-100-or-4

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tot = nums1.length + nums2.length;
        double m1 = getKth(nums1, 0, nums2, 0, (tot + 1) / 2);
        double m2 = getKth(nums1, 0, nums2, 0, (tot + 2) / 2);
        return (m1 + m2) / 2;
    }

    private double getKth(int[] nums1, int p1, int[] nums2, int p2, int k) {
        if (p1 >= nums1.length) {
            return nums2[p2 + k - 1];
        }
        if (p2 >= nums2.length) {
            return nums1[p1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[p1], nums2[p2]);
        }

        int n1 = p1 + k / 2 - 1 < nums1.length ? nums1[p1 + k / 2 - 1] : Integer.MAX_VALUE;
        int n2 = p2 + k / 2 - 1 < nums2.length ? nums2[p2 + k / 2 - 1] : Integer.MAX_VALUE;
        return n1 < n2 ? getKth(nums1, p1 + k / 2, nums2, p2, k - k / 2) :
                getKth(nums1, p1, nums2, p2 + k / 2, k - k / 2);
    }

}
