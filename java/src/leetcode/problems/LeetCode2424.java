package leetcode.problems;

import knowledge.datastructure.adv.BITree;
import knowledge.datastructure.adv.UnionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/5 12:57
 * <a href="https://leetcode.cn/problems/longest-uploaded-prefix/solutions/2081868/shu-zhuang-shu-zu-by-sarihust-xnct/"></a>
 */
public class LeetCode2424 {

    class LUPrefix {
        BITree bitTree;
        int n;

        public LUPrefix(int n) {
            this.n = n;
            this.bitTree = new BITree(n + 1);
        }

        public void upload(int video) {
            bitTree.add(video, 1);
        }

        public int longest() {
            int l = 0;
            int r = n;
            while (l < r) {
                int m = l + r + 1 >> 1;
                if (bitTree.sum(m) - bitTree.sum(0) < m) r = m - 1;
                else l = m;
            }
            return l;
        }
    }

    class LUPrefix_uf {
        private UnionFind uf;
        private boolean[] uploaded;
        private int n;

        public LUPrefix_uf(int n) {
            this.n = n;
            this.uf = new UnionFind(n + 1); // 索引从1到n
            this.uploaded = new boolean[n + 1];
        }

        public void upload(int video) {
            if (video < 1 || video > n || uploaded[video]) {
                return;
            }

            uploaded[video] = true;

            // 如果左边有视频，合并到左边的集合
            if (video > 1 && uploaded[video - 1]) {
                uf.union(video - 1, video);
            }

            // 如果右边有视频，合并到右边的集合
            if (video < n && uploaded[video + 1]) {
                uf.union(video, video + 1);
            }
        }

        public int longest() {
            // 如果视频1没有上传，直接返回0
            if (!uploaded[1]) {
                return 0;
            }

            // 找到包含视频1的连续段，返回该段的大小
            return uf.sizeOfSet(1);
        }
    }


    class LUPrefix_opt {
        private int x;
        private final Map<Integer, Boolean> has;

        public LUPrefix_opt(int n) {
            this.x = 1;
            this.has = new HashMap<>();
        }

        public void upload(int video) {
            has.put(video, true);
        }

        // 时间复杂度：均摊 O(1)
        public int longest() {
            while (has.containsKey(x)) {
                x++;
            }
            return x - 1;
        }
    }
}
