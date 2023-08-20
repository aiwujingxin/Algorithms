package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/31 18:27
 */
public class LeetCode1438_Q {

    public int longestSubarray(int[] nums, int limit) {
        //Sliding window
        if (nums.length == 1) {
            return 1;
        }
        int size = 2;
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        minQ.add(nums[0]);
        maxQ.add(nums[0]);
        for (int i = 0, j = i + 1; j < nums.length; ) {
            minQ.add(nums[j]);
            maxQ.add(nums[j]);
            int min = minQ.peek();
            int max = maxQ.peek();
            if (Math.abs(max - min) <= limit) {
                j++;
                size = Math.max(size, j - i);
            } else {
                minQ.remove(nums[i]);
                maxQ.remove(nums[i]);
                i++;
                j++;
            }
        }
        return size;
    }
}
