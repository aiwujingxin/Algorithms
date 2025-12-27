package leetcode.problems;

import knowledge.datastructure.adv.UnionFind;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/5 19:11
 */
public class LeetCode765 {

    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len / 2;
        UnionFind uf = new UnionFind(N);
        // 遍历每一张“沙发”（步长为 2）
        for (int i = 0; i < len; i += 2) {
            int person1 = row[i];
            int person2 = row[i + 1];
            // 计算这两个人分别属于哪一对情侣
            int coupleID1 = person1 / 2;
            int coupleID2 = person2 / 2;
            // 如果这两个人不是同一对情侣，就把这两对情侣在图中连起来
            if (coupleID1 != coupleID2) {
                uf.union(coupleID1, coupleID2);
            }
        }
        // 最小交换次数 = 总情侣对数 - 连通块数量
        return N - uf.getCount();
    }
}
