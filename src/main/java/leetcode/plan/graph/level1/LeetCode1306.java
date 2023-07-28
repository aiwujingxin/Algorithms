package leetcode.plan.graph.level1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/19 22:26
 */
public class LeetCode1306 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1306().canReach(new int[]{58, 48, 64, 36, 19, 19, 67, 13, 32, 2, 59, 50, 29, 68, 50, 0, 69, 31, 54, 20, 22, 43, 30, 9, 68, 71, 20, 22, 48, 74, 2, 65, 27, 54, 30, 5, 66, 24, 64, 68, 9, 31, 50, 59, 15, 72, 6, 49, 11, 71, 12, 61, 5, 66, 30, 1, 2, 39, 59, 35, 53, 21, 76, 17, 71, 40, 68, 57, 64, 53, 70, 21, 50, 49, 25, 63, 35}, 46));
    }

    public boolean canReach(int[] arr, int start) {
        if (start >= arr.length) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(start);
        set.add(start);

        while (!queue.isEmpty()) {
            int index = queue.poll();

            if (arr[index] == 0) {
                return true;
            }

            if (index + arr[index] >= 0 && index + arr[index] < arr.length && !set.contains(index + arr[index])) {
                queue.add(index + arr[index]);
                set.add(index + arr[index]);
            }
            if (index - arr[index] >= 0 && index - arr[index] < arr.length && !set.contains(index - arr[index])) {
                queue.add(index - arr[index]);
                set.add(index - arr[index]);

            }
        }
        return false;
    }
}
