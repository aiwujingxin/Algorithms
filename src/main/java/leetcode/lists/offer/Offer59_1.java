package leetcode.lists.offer;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-12-04 3:52 下午
 */
public class Offer59_1 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Offer59_1().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(
                Arrays.toString(new Offer59_1().maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5)));
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]
        );
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            if (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

}
