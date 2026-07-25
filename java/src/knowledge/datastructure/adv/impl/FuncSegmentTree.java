package knowledge.datastructure.adv.impl;

/**
 * 泛型解耦的线段树 (Functional Interface Segment Tree)。
 * 使用 Merger 接口将区间的合并逻辑（如求和、最大值、最小值等）解耦。
 */
public class FuncSegmentTree<T> {

    public interface Merger<T> {
        T merge(T a, T b);
    }

    private final T[] tree;
    private final T[] data;
    private final Merger<T> merger;

    @SuppressWarnings("unchecked")
    public FuncSegmentTree(T[] arr, Merger<T> merger) {
        this.merger = merger;
        this.data = (T[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.data[i] = arr[i];
        }
        this.tree = (T[]) new Object[arr.length * 4];
        if (arr.length > 0) {
            build(0, 0, data.length - 1);
        }
    }

    private void build(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = 2 * treeIndex + 1;
        int rightTreeIndex = 2 * treeIndex + 2;
        int mid = l + (r - l) / 2;
        build(leftTreeIndex, l, mid);
        build(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    /**
     * 单点更新：将 index 处的值更新为 e
     */
    public void set(int index, T e) {
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, T e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = 2 * treeIndex + 1;
        int rightTreeIndex = 2 * treeIndex + 2;
        if (index <= mid) {
            set(leftTreeIndex, l, mid, index, e);
        } else {
            set(rightTreeIndex, mid + 1, r, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    /**
     * 区间查询：查询 [queryL, queryR] 范围内的结果
     */
    public T query(int queryL, int queryR) {
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private T query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = 2 * treeIndex + 1;
        int rightTreeIndex = 2 * treeIndex + 2;
        if (queryL > mid) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }
        T leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        T rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }
}