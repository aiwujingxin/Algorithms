package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/23 14:01
 */
public class LeetCode373 {

    // unknown
    //https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation

    //https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/solution/bu-chong-guan-fang-ti-jie-you-xian-dui-l-htf8/
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }

        for (int i = 0; i < nums1.length && i < k; i++) {
            que.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !que.isEmpty()) {
            int[] cur = que.poll();
            res.add(new ArrayList<>() {{
                add(cur[0]);
                add(cur[1]);
            }});
            if (cur[2] == nums2.length - 1) {
                continue;
            }

            que.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }

}
