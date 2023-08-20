package leetcode;

/**
 * @author jingxinwu
 * @date 2021-11-16 11:31 下午
 */
public class LeetCode42 {


    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int water = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }
        int leftMax = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            } else {
                water = water + leftMax - height[i];
            }
        }

        int rightMax = 0;
        for (int i = height.length - 1; i > maxIndex; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            } else {
                water = water + rightMax - height[i];
            }
        }
        return water;
    }
}
