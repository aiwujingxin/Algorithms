package knowledge.datastructure.other.impl;

import knowledge.datastructure.other.MinMaxContainer;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 8/20/25 10:59
 */

class SegmentTreeMinMax implements MinMaxContainer {
    private int[] sorted;              // 离散化后的值 -> 原始值
    private Map<Integer, Integer> map; // 原始值 -> 离散化下标
    private int n;
    private int[] minTree, maxTree, count;

    public SegmentTreeMinMax(int[] nums) {
        // 1. 离散化
        sorted = Arrays.stream(nums).distinct().sorted().toArray();
        map = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i);
        }
        n = sorted.length - 1;

        // 2. SegmentTree 初始化
        minTree = new int[4 * (n + 1)];
        maxTree = new int[4 * (n + 1)];
        count = new int[n + 1];
        build(1, 0, n);
    }

    private void build(int idx, int l, int r) {
        if (l == r) {
            minTree[idx] = Integer.MAX_VALUE;
            maxTree[idx] = Integer.MIN_VALUE;
            return;
        }
        int mid = (l + r) / 2;
        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);
        pull(idx);
    }

    public void insert(int x) {
        int pos = map.get(x);
        count[pos]++;
        update(1, 0, n, pos, true);
    }

    public void remove(int x) {
        int pos = map.get(x);
        if (count[pos] > 0) {
            count[pos]--;
            if (count[pos] == 0) {
                update(1, 0, n, pos, false);
            }
        }
    }

    public int getMin() {
        return sorted[minTree[1]];
    }

    public int getMax() {
        return sorted[maxTree[1]];
    }

    public boolean isEmpty() {
        return minTree[1] == Integer.MAX_VALUE;
    }

    private void update(int idx, int l, int r, int pos, boolean insert) {
        if (l == r) {
            if (insert) {
                minTree[idx] = maxTree[idx] = pos;
            } else {
                if (count[pos] == 0) {
                    minTree[idx] = Integer.MAX_VALUE;
                    maxTree[idx] = Integer.MIN_VALUE;
                }
            }
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) update(idx * 2, l, mid, pos, insert);
        else update(idx * 2 + 1, mid + 1, r, pos, insert);
        pull(idx);
    }

    private void pull(int idx) {
        minTree[idx] = Math.min(minTree[idx * 2], minTree[idx * 2 + 1]);
        maxTree[idx] = Math.max(maxTree[idx * 2], maxTree[idx * 2 + 1]);
    }
}