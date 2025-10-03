package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/14/25 13:52
 */
public class LeetCode2541 {

    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] != nums2[i]) return -1;
            }
            return 0;
        }
        int n = nums1.length;
        long k1 = 0;
        long k2 = 0;
        for (int i = 0; i < n; i++) {
            int t = nums1[i] - nums2[i];
            if (t % k != 0)
                return -1;
            if (t < 0) {
                k1 += t / k;
            } else {
                k2 += t / k;
            }
        }
        if (-k1 != k2) return -1;
        return k2;
    }
}
