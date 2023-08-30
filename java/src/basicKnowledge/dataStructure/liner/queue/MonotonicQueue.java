package basicKnowledge.dataStructure.liner.queue;


import java.util.ArrayDeque;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 22:04
 * @see leetcode.LeetCode239
 * @link <a href="https://leetcode.com/problems/sliding-window-maximum/discuss/2651803/Java-O(n)-solution-using-deque">...</a>
 */
public class MonotonicQueue {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = new MonotonicQueue().maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //比较队尾元素和将要进来的值，如果小的话就都移除
            // maintain monotonic decreasing.
            // all elements in the deque smaller than the current one
            // have no chance of being the maximum, so get rid of them
            // queue 单调递减队列 大--->小
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            // 如果队首存储的角标就是滑动窗口左边界数值，就移除队首
            // 如果此时队列的首元素是 i-k 的话，表示此时窗口向右移了一步，则移除队首元素
            if (queue.getFirst() == i - k) {
                queue.removeFirst();
            }
            // 将队首角标对应元素(窗口最大值)放入结果数组
            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return ans;
    }

}
