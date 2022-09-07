package leetcode.problems;

import java.util.ArrayList;
import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/8/1 21:56
 */
public class LeetCode218 {

    static class Pair implements Comparable<Pair> {
        int point;
        int height;

        Pair(int p, int h) {
            this.point = p;
            this.height = h;
        }

        public int compareTo(Pair p) {
            if (this.point == p.point) {
                return p.height - this.height;
            } else {
                return this.point - p.point;
            }
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int[] building : buildings) {
            list.add(new Pair(building[0], building[2]));
            list.add(new Pair(building[1], -building[2]));
        }
        Collections.sort(list);
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);

        for (Pair it : list) {
            int top = pq.peek();
            if (it.height >= 0) {
                pq.add(it.height);
            } else {
                pq.remove(-it.height);
            }
            if (top != pq.peek()) {
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add(it.point);
                curr.add(pq.peek());
                ans.add(curr);
            }
        }

        return ans;
    }
}
