package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/6 23:47
 */

//https://leetcode.com/problems/sliding-window-maximum/solutions/282816/simple-java-solution-only-using-an-array-and-some-index-logic-1ms/
public class LeetCode239_window_TEL {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] maxWindow = new int[nums.length - k + 1];
        int windowIndex = 0;
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }

        maxWindow[windowIndex] = max;
        windowIndex++;

        for (int i = k; i < nums.length; i++) {

            if (maxIndex <= i - k) { // 如果最大的值被排除在外了
                //  需要重新寻找到这个窗口里的最大值
                max = nums[i - k + 1];
                maxIndex = i - k + 1;
                for (int j = i - k + 1; j <= i; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            } else if (max < nums[i]) { //如果这个最大值还在窗口内
                //则只需要比较一下当前值和最大值
                max = nums[i];
                maxIndex = i;
            }
            maxWindow[windowIndex] = max;
            windowIndex++;
        }
        return maxWindow;
    }
}
