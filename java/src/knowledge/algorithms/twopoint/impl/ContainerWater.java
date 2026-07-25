package knowledge.algorithms.twopoint.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 对撞指针求容量 (Container / Trapping Rain)
 * <适用场景>
 * 由左右边界高度决定容量的问题：盛最多水的容器、接雨水。
 * <核心>
 * 短板决定当前容量，移动较矮的一侧才可能变大；接雨水维护两侧已见最大高度，
 * 每步结算较矮一侧的积水，保证该侧的瓶颈已确定。
 */
public class ContainerWater {

    /**
     * 盛最多水的容器：两条竖线与 x 轴围成的最大面积（LeetCode 11）。
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, best = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            best = Math.max(best, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return best;
    }

    /**
     * 接雨水：柱状图能接的雨水总量，O(1) 空间对撞指针（LeetCode 42）。
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, total = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                total += leftMax - height[left];
                left++;
            } else {
                total += rightMax - height[right];
                right--;
            }
        }
        return total;
    }
}
