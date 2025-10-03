package leetcode.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 9/8/25 21:52
 */
public class LeetCode1942 {

    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{times[i][0], times[i][1], i};
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        PriorityQueue<Integer> seat = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            seat.add(i);
        }
        PriorityQueue<int[]> dq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[2] - o2[2];
            }
            return o1[1] - o2[1];
        });
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peek()[1] <= arr[i][0]) {
                seat.add(dq.poll()[2]);
            }
            int pi = seat.poll();
            dq.add(new int[]{arr[i][0], arr[i][1], pi});
            if (arr[i][2] == targetFriend) {
                return pi;
            }
        }
        return -1;
    }
}
