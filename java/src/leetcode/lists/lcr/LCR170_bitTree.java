package leetcode.lists.lcr;

import knowledge.datastructure.adv.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/10 21:08
 */
public class LCR170_bitTree {

    public int reversePairs(int[] record) {
        int n = record.length;
        int ans = 0;
        // 离散化 TreeSet排序
        Set<Integer> set = new TreeSet<>();
        for (int num : record) {
            set.add(num);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer num : set) {
            map.put(num, rank++);
        }
        // 树状数组统计逆序对
        BITree tree = new BITree(n);
        for (int i = n - 1; i >= 0; i--) {
            rank = map.get(record[i]);
            ans += tree.sum(rank - 1);
            tree.add(rank, 1);
        }
        return ans;
    }
}
