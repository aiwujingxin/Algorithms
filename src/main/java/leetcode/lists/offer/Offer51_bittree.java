package leetcode.lists.offer;

import basic.advstructure.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 19:10
 */
public class Offer51_bittree {

    //https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/bao-li-jie-fa-fen-zhi-si-xiang-shu-zhuang-shu-zu-b/
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }
        // 离散化：使得数字更紧凑，节约树状数组的空间
        // 1、使用二分搜索树是为了去掉重复元素
        Set<Integer> treeSet = new TreeSet<>();
        for (int j : nums) {
            treeSet.add(j);
        }
        // 2、把排名存在哈希表里方便查询
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rankIndex = 1;
        for (Integer num : treeSet) {
            rankMap.put(num, rankIndex);
            rankIndex++;
        }

        int count = 0;
        // 在树状数组内部完成前缀和的计算
        // 规则是：从后向前，先给对应的排名 + 1，再查询前缀和
        BinaryIndexedTree tree = new BinaryIndexedTree(rankMap.size());

        for (int i = len - 1; i >= 0; i--) {
            int rank = rankMap.get(nums[i]);
            tree.update(rank, 1);
            count += tree.query(rank - 1);
        }
        return count;
    }
}
