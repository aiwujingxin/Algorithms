package basic.advstructure;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 18:32
 * <a href=
 * "https://leetcode.cn/problems/range-sum-query-mutable/solution/guan-yu-ge-lei-qu-jian-he-wen-ti-ru-he-x-41hv/">模版</a>
 * <a href="https://www.youtube.com/watch?v=v2Q4ZjPeFuc">讲解</a>
 */
public class BinaryIndexedTree {

    int[] tree;
    int len;

    public BinaryIndexedTree(int n) {
        this.len = n;
        this.tree = new int[n + 1];
    }

    public int lowbit(int i) {
        return i & (-i);
    }

    public void update(int i, int delta) {// update the node and his parent node,找parent的方式是把最右边的1砍掉
        while (i <= len) {
            tree[i] += delta;
            i += lowbit(i);
        }
    }

    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowbit(i);
        }
        return sum;
    }
}

/*
 *
 * public static void main(String[] args) {
 * int[] freq = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
 * int n = freq.length;
 * BITTree tree = new BITTree(n);
 *
 * // Build fenwick tree from given array
 * for (int i = 0; i < freq.length; i++) {
 * tree.update(i + 1, freq[i]);
 * }
 *
 * System.out.println("Sum of elements in arr[0..5]" + " is " + tree.query(5));
 *
 * // Let use test the update operation
 * freq[3] += 6;
 *
 * // Update BIT for above change in arr[]
 * tree.update(3, 6);
 *
 * // Find sum after the value is updated
 * System.out.println("Sum of elements in arr[0..5]" + " after update is " +
 * tree.query(5));
 * }
 */
