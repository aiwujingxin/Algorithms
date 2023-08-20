package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author jingxinwu
 * @date 2021-11-21 10:30 下午
 */
public class LeetCode658_Q {


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //custom sort function
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a - x) == Math.abs(b - x)) {
                return a - b;
            } else {
                return Math.abs(a - x) - Math.abs(b - x);
            }
        });

        for (int j : arr) {
            queue.add(j);
        }

        List<Integer> lst = new ArrayList<>();
        while (k > 0) {
            lst.add(queue.remove());
            k--;
        }
        Collections.sort(lst);
        return lst;
    }
}
