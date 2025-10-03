package knowledge.datastructure.stack;

import leetcode.problems.*;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/13 22:08
 * @description 单调栈 当前位置的 左(右)侧比当前位置的数字小(大)，且距离最近的位置 在哪
 * <单调栈>
 * @see LeetCode739     每日温度
 * @see LeetCode84
 * @see LeetCode2104
 * @see LeetCode907
 * @see LeetCode316
 * @see LeetCode334     递增三元组（类似边界预处理）
 * <单调栈 贪心>
 * @see LeetCode581
 * @see LeetCode962
 * @see LeetCode402
 * @see LeetCode853     车队
 * <左右边界预处理> 需要快速查询每个元素左侧和右侧的极值或边界信息。
 * @see LeetCode915     分割数组（leftMax[] + rightMin[]）
 * @see LeetCode135     分发糖果（左右各一次遍历）
 * @see LeetCode2420    找到所有好索引（左右非递增/非递减）
 * @see LeetCode2012    数组美丽值
 * @see LeetCode2909    元素和最小的山形三元组（类似左右最小）
 * @see LeetCode238     除自身以外数组的乘积
 * @see LeetCode3350    检测相邻递增子数组 II
 */
public class MonotonicStack {

    //左侧 最近 且 严格大于
    public int[] leftMax(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            leftMax[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return leftMax;
    }

    //左侧 最近 且 严格小于
    public int[] leftMin(int[] nums) {
        int n = nums.length;
        int[] leftMin = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            leftMin[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return leftMin;
    }

    // 右侧 最近 且 严格大于
    public int[] rightMax(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            rightMax[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return rightMax;
    }

    // 右侧 最近 且 严格小于
    public int[] rightMin(int[] nums) {
        int n = nums.length;
        int[] rightMin = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            rightMin[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return rightMin;
    }
}
