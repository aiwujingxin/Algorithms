package leetcode.plan.datastructure.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 18:08
 */
public class LeetCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index1 = m + n - 1;
        int a = m - 1;
        int b = n - 1;

        while (a >= 0 && b >= 0) {
            if (nums1[a] < nums2[b]) {
                nums1[index1] = nums2[b];
                b--;
            } else {
                nums1[index1] = nums1[a];
                a--;
            }
            index1--;
        }
        while (a >= 0) {
            nums1[index1] = nums1[a];
            a--;
            index1--;
        }
        while (b >= 0) {
            nums1[index1] = nums2[b];
            b--;
            index1--;
        }

    }
}
