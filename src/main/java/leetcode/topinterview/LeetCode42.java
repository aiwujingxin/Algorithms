package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/22 00:57
 */
public class LeetCode42 {

    public static void main(String[] args) {
        System.out.println(new LeetCode42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int left = Integer.MIN_VALUE;
        int[] leftMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (height[i] > left) {
                left = height[i];
            }
            leftMax[i] = left;
        }
        int right = Integer.MIN_VALUE;
        int[] rightMax = new int[height.length];
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > right) {
                right = height[i];
            }
            rightMax[i] = right;
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;

    }
}
