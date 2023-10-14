package leetcode.lists.lcr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 23:08
 */
public class LCR61 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] + o2[1] - (o1[0] + o1[1]);
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.add(new int[]{nums1[i], nums2[j]});
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int n = Math.min(k, queue.size());
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            int[] node = queue.poll();
            list.add(node[0]);
            list.add(node[1]);
            res.add(list);
        }
        return res;
    }
}
