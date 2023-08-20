package basic.advstructure;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 18:32
 * @link <a href=
 *       "https://leetcode.cn/problems/range-sum-query-mutable/solution/guan-yu-ge-lei-qu-jian-he-wen-ti-ru-he-x-41hv/">模版</a>
 * @link<a href="https://www.youtube.com/watch?v=v2Q4ZjPeFuc">讲解</a>
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