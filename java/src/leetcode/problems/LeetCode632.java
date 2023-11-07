package leetcode.problems;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/24 22:45
 */
public class LeetCode632 {

    //https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/discuss/591029/Java-PriorityQueue-Easy-Solution-with-simple-explanation


    //https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/solution/tan-xin-duo-zhi-zhen-you-xian-ji-dui-lie-by-girapa/
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        int minx = Integer.MAX_VALUE;
        // 堆元素中的最大值
        int maxy = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> i[0] - j[0]);
        for (int i = 0; i < nums.size(); i++) {
            //get the maximun value from first element of every list
            if (nums.get(i).get(0) > maxy) {
                maxy = nums.get(i).get(0);
            }
            //dumping the value in min heap based on the values
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
        }

        while (!pq.isEmpty()) {
            //get the min-value from the heap
            int[] min = pq.poll();
            int i = min[1];
            int j = min[2];
            //compare the value of min value with max value and updayte the minrange which would be storing the answer
            if (maxy - min[0] < minRange) { //？ 如何确保已经包含了所有k个列表？
                minRange = maxy - min[0];
                res[0] = min[0];
                res[1] = maxy;
            }
            //get the next value from the list in which the minimum is found and update the value of min-heap and maxy accordingly.
            if (i < nums.size() && j + 1 < nums.get(i).size()) {
                pq.offer(new int[]{nums.get(i).get(j + 1), i, j + 1}); // 判断i 的下一个元素
                if (nums.get(i).get(j + 1) > maxy) {
                    maxy = nums.get(i).get(j + 1);
                }
            } else {
                //If any of the list is traversed, break out of the loop
                break;
            }
        }
        //return the result.
        return res;
    }
}
