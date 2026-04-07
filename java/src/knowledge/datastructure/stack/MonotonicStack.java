package knowledge.datastructure.stack;

import leetcode.problems.*;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/13 22:08
 * @description 单调栈 当前位置的 左(右)侧比当前位置的数字小(大)，且距离最近的位置 在哪
 * <基础>
 * @see LeetCode739     每日温度
 * @see LeetCode496     下一个更大元素 I
 * @see LeetCode503     下一个更大元素 II
 * <矩形>
 * @see LeetCode42      接雨水
 * @see LeetCode84      柱状图中最大的矩形
 * @see LeetCode85      最大矩形
 * @see LeetCode221     最大正方形
 * @see LeetCode1504    统计全 1 子矩形
 * @see LeetCode1277    统计全为 1 的正方形子矩阵
 * <贪心构造>
 * @see LeetCode316     去除重复字母
 * @see LeetCode402     移掉 K 位数字 (核心)
 * @see LeetCode581     最短无序连续子数组
 * @see LeetCode962     最大宽度坡
 * @see LeetCode853     车队
 * @see LeetCode321     拼接最大数 (双栈合并)
 * @see LeetCode1081    不同字符的最小子序列
 * <边界>
 * @see LeetCode334     递增三元组（类似边界预处理）
 * @see LeetCode907     子数组的最小值之和
 * @see LeetCode2104    子数组范围和
 * @see LeetCode915     分割数组（leftMax[] + rightMin[]）
 * @see LeetCode135     分发糖果（左右各一次遍历）
 * @see LeetCode2420    找到所有好索引（左右非递增/非递减）
 * @see LeetCode2012    数组美丽值
 * @see LeetCode2909    元素和最小的山形三元组（类似左右最小）
 * @see LeetCode3350    检测相邻递增子数组 II
 */
public class MonotonicStack {

    /**
     * 寻找左侧最近且严格大于当前元素的下标
     * 维护单调递减栈
     */
    public int[] leftMax(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {// 如果求严格小于，改成 >=
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }

    /**
     * 寻找右侧最近且严格大于当前元素的下标
     * 维护单调递减栈 (从右向左遍历)
     */
    public int[] rightMax(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {// 如果求严格小于，改成 >=
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }
}