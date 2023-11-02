package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/2 16:18
 */
public class LeetCode165 {

    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n = 0;
        int m = 0;
        while (n < nums1.length || m < nums2.length) {
            int num1 = n >= nums1.length ? 0 : Integer.parseInt(nums1[n]);
            int num2 = m >= nums2.length ? 0 : Integer.parseInt(nums2[n]);
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
            n++;
            m++;
        }
        return 0;
    }
}
