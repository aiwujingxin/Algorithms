package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/8/1 22:25
 */
public class LeetCode218_segment_tree {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return new ArrayList<>();
        }
        return new SegmentTree(buildings).getSkyline();
    }

    //https://leetcode.cn/problems/the-skyline-problem/solution/javaxian-duan-shu-jie-fa-by-vigilant-her-uc45/
    public static class SegmentTree {
        private final TreeMap<Integer, Integer> truthToVirtual;
        //buildings 房子数据
        int[][] buildings;
        //更新
        int[] change;
        boolean[] update;
        //max
        int[] max;
        private int N;//数组长度，有几个不同的坐标

        public SegmentTree(int[][] buildings) {
            this.buildings = buildings;
            //下标离散化
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int[] building : buildings) {
                treeSet.add(building[0]);//left
                treeSet.add(building[1]);//right
            }
            //key=truth(like 10,20000)-->value=virtual(like 0,1)
            N = 0;
            truthToVirtual = new TreeMap<>();
            while (!treeSet.isEmpty()) {
                truthToVirtual.put(treeSet.pollFirst(), N++);
            }

            int MAXN = N << 2;
            change = new int[MAXN];
            update = new boolean[MAXN];
            max = new int[MAXN];
        }

        public List<List<Integer>> getSkyline() {
            List<List<Integer>> res = new ArrayList<>();
            this.fallingAll();
            //抓天际线
            int last = 0;
            while (!truthToVirtual.isEmpty()) {
                Map.Entry<Integer, Integer> entry = truthToVirtual.pollFirstEntry();
                int idx = entry.getValue();
                int queryMax = query(idx, idx, 0, N - 1, 1);
                if (queryMax != last) {
                    res.add(Arrays.asList(entry.getKey(), queryMax));
                    last = queryMax;
                }
            }
            return res;
        }

        private int query(int l, int r, int L, int R, int it) {
            if (l <= L && r >= R) {
                return max[it];
            }
            //任务下发
            pushDown(it);
            int mid = ((R - L) >> 1) + L;
            int leftChild = it << 1;
            int maxQuery = Integer.MIN_VALUE;
            int rightChild = leftChild | 1;
            if (l <= mid) {
                maxQuery = Math.max(query(l, r, L, mid, leftChild), maxQuery);
            }
            if (r > mid) {
                maxQuery = Math.max(query(l, r, mid + 1, R, rightChild), maxQuery);
            }
            pushUp(it, leftChild, rightChild);
            return maxQuery;
        }

        private void fallingAll() {
            for (int[] building : buildings) {
                int left = truthToVirtual.get(building[0]);
                int right = truthToVirtual.get(building[1]);
                int height = building[2];
                //不包尾，全更新成height,和原来上面的值进行权衡，留大的那个
                this.update(left, Math.max(left, right - 1), height, 0, N - 1, 1);
            }
        }

        //l...r更新为c，此时在L..R范围上,L...R的值存在it上
        private void update(int l, int r, int c, int L, int R, int it) {
            if (l <= L && r >= R) {
                //可以懒住
                update[it] = true;
                change[it] = Math.max(change[it], c);
                max[it] = Math.max(max[it], c);
                return;
            }
            //懒不住，任务下发
            int mid = ((R - L) >> 1) + L;
            pushDown(it);
            int leftChild = it << 1;
            int rightChild = leftChild | 1;
            if (l <= mid) {
                update(l, r, c, L, mid, leftChild);
            }
            if (r > mid) {
                update(l, r, c, mid + 1, R, rightChild);
            }
            pushUp(it, leftChild, rightChild);
        }


        private void pushUp(int it, int left, int right) {
            max[it] = Math.max(max[left], max[right]);
        }

        //将任务下发到左右分区
        private void pushDown(int it) {
            int leftChild = it << 1;//规定0下标不存东西，这样左孩子就是2*i,
            int rightChild = leftChild | 1;
            if (update[it]) {
                max[leftChild] = Math.max(max[leftChild], change[it]);
                max[rightChild] = Math.max(max[rightChild], change[it]);
                update[it] = false;
                update[leftChild] = true;
                update[rightChild] = true;
                change[leftChild] = Math.max(change[leftChild], change[it]);
                change[rightChild] = Math.max(change[rightChild], change[it]);
                change[it] = 0;
            }
        }
    }
}
