package leetcode.problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/6 23:56
 */

//https://leetcode.com/problems/sliding-window-maximum/solutions/258174/java-detailed-explanation-deque/
public class LeetCode239_Deque_v2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] out = new int[nums.length - k + 1]; // the result array
        if (k == 0) {
            return new int[0];
        }

        int count = 0; // results count
        // As deque is a double ended queue
        // the maximum element is stored at the front of queue (leftmost box)
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            // if window moves forward, the first element of deque has to be removed
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {

                dq.removeFirst();
            }

            // as long as nums[i] has value greater than deque, keep popping elements of deque
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }

            // add the index in deque
            dq.addLast(i);

            // once a window is over, take its front value(which is the max) and put it in results
            if (i >= k - 1) {

                out[count] = nums[dq.peekFirst()];
                count++;
            }

        }
        return out;

    }
}
