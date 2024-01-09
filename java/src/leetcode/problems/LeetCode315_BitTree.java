package leetcode.problems;

import knowledge.advstructure.BinaryIndexedTree;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/23 19:29
 * @link <a href="https://leetcode.cn/problems/count-of-smaller-numbers-after-self/solutions/15614/shu-zhuang-shu-zu-by-liweiwei1419/">...</a>
 */
public class LeetCode315_BitTree {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 排名表 离散化 树状数组 底层的数组空间会更紧凑，更易于维护
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer num : set) {
            map.put(num, rank);
            rank++;
        }
        BinaryIndexedTree tree = new BinaryIndexedTree(set.size() + 1);
        // 从后向前填表
        for (int i = n - 1; i >= 0; i--) {
            // 1、查询排名
            rank = map.get(nums[i]);
            // 2、在树状数组排名的那个位置 + 1
            tree.update(rank, 1);
            // 3、查询一下小于等于“当前排名 - 1”的元素有多少
            res.add(tree.query(rank - 1));
        }
        Collections.reverse(res);
        return res;
    }
}
