package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-26 10:00 PM
 */
public class LeetCode718 {

    public static void main(String[] args) {
        System.out.println(new LeetCode718().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }


    public int findLength(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return 0;
        }

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[nums1.length][nums2.length];
    }

}
