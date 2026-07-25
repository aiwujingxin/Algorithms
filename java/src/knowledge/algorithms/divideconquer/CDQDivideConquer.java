package knowledge.algorithms.divideconquer;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description CDQ 分治 (三维偏序 / 陌上花开)
 * <适用场景>
 * 统计每个元素 j 满足 a[i]≤a[j] && b[i]≤b[j] && c[i]≤c[j] 的 i 的个数（三维偏序）。
 * 用分治消掉一维、归并处理第二维、树状数组处理第三维，总复杂度 O(n log^2 n)。
 * <核心>
 * 先按第一维排序（消一维），CDQ 分治对第二维归并，保证左半的第二维都 ≤ 右半；
 * 归并过程中把左半元素的第三维插入树状数组，右半元素查询前缀和即得贡献。
 * 需先对完全相同的三元组去重合并，避免相等元素互相漏算。
 */
public class CDQDivideConquer {

    private static class Node {
        int a, b, c, count, answer;
    }

    private final int[] tree;
    private final int maxC;

    public CDQDivideConquer(int maxC) {
        this.maxC = maxC;
        this.tree = new int[maxC + 1];
    }

    private void add(int i, int v) {
        for (; i <= maxC; i += i & (-i)) tree[i] += v;
    }

    private int sum(int i) {
        int s = 0;
        for (; i > 0; i -= i & (-i)) s += tree[i];
        return s;
    }

    /**
     * 输入 n 个三元组 (a,b,c)，返回长度 n+? 的答案分布：
     * result[k] = 支配数（含自身相等）恰为 k+1 的元素个数。
     */
    public int[] solve(int[][] points) {
        int n = points.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            Node node = new Node();
            node.a = points[i][0];
            node.b = points[i][1];
            node.c = points[i][2];
            node.count = 1;
            nodes[i] = node;
        }
        // 第一维排序，相同三元组合并计数
        Arrays.sort(nodes, (x, y) -> {
            if (x.a != y.a) return x.a - y.a;
            if (x.b != y.b) return x.b - y.b;
            return x.c - y.c;
        });
        Node[] unique = new Node[n];
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (m > 0 && unique[m - 1].a == nodes[i].a
                    && unique[m - 1].b == nodes[i].b
                    && unique[m - 1].c == nodes[i].c) {
                unique[m - 1].count++;
            } else {
                unique[m++] = nodes[i];
            }
        }
        Node[] arr = Arrays.copyOf(unique, m);
        cdq(arr, 0, m - 1);

        int[] result = new int[n];
        for (Node node : arr) {
            // 相等三元组之间互相支配：answer 再加上同组其余元素
            int dominated = node.answer + node.count - 1;
            result[dominated] += node.count;
        }
        return result;
    }

    private void cdq(Node[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >>> 1;
        cdq(arr, left, mid);
        cdq(arr, mid + 1, right);
        // 按第二维归并，左半贡献给右半
        Node[] temp = new Node[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i].b <= arr[j].b) {
                add(arr[i].c, arr[i].count);
                temp[k++] = arr[i++];
            } else {
                arr[j].answer += sum(arr[j].c);
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            add(arr[i].c, arr[i].count);
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            arr[j].answer += sum(arr[j].c);
            temp[k++] = arr[j++];
        }
        // 撤销本层对树状数组的修改
        for (int t = left; t <= mid; t++) add(arr[t].c, -arr[t].count);
        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
