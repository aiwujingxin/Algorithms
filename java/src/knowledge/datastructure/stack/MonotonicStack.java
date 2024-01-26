package knowledge.datastructure.stack;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/13 22:08
 * @description 单调栈
 * <解决问题>
 * 每个位置都求：
 * 0）当前位置的 左侧比当前位置的数字小，且距离最近的位置 在哪
 * 1）当前位置的 右侧比当前位置的数字小，且距离最近的位置 在哪
 * 或者
 * 每个位置都求：
 * 0）当前位置的 左侧比当前位置的数字大，且距离最近的位置 在哪
 * 1）当前位置的 右侧比当前位置的数字大，且距离最近的位置 在哪
 * @see leetcode.problems.LeetCode739 每日温度
 * @see leetcode.problems.LeetCode84
 * @see leetcode.problems.LeetCode2104
 * @see leetcode.problems.LeetCode907
 * 单调栈+贪心
 * @see leetcode.problems.LeetCode581
 * @see leetcode.problems.LeetCode962
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
