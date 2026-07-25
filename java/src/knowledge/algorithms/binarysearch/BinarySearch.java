package knowledge.algorithms.binarysearch;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:27
 * @description 二分查找
 * <本质> 区间的二段性（Bisection）
 * 数组不一定要整体有序（如旋转数组、山脉数组），只要能构造出某种性质，使得 mid 的一侧肯定不包含目标值，即可二分。
 * 二分查找的本质是通过满足特定单调性的 check 逻辑，在每一轮迭代中可靠地排除掉一半不包含答案的搜索区间
 * 从而将解空间对数级压缩至边界收敛。
 * <整数>
 * @see LeetCode704     二分查找
 * @see LeetCode34      在排序数组中查找元素的第一个和最后一个位置
 * @see LeetCode35      搜索插入位置
 * @see LeetCode33      搜索旋转排序数组
 * @see LeetCode81      搜索旋转排序数组 II
 * @see LeetCode153     寻找旋转排序数组中的最小值
 * @see LeetCode154     寻找旋转排序数组中的最小值II
 * @see LeetCode162     寻找峰值
 * @see LeetCode268     丢失的数字
 * @see LeetCode852     山脉数组的峰顶索引
 * @see LeetCode367     有效的完全平方数
 * @see LeetCode1855    下标对中的最大距离
 * @see LeetCode1539    第 k 个缺失的正整数
 * @see LeetCode719     找出第 K 小的数对距离
 * <二分答案 (在值域上二分，判定可行性)>
 * @see LeetCode875     爱吃香蕉的珂珂
 * @see LeetCode1011    在 D 天内送达包裹的能力
 * @see LeetCode410     分割数组的最大值
 * @see LeetCode1482    制作 m 束花所需的最少天数
 * @see LeetCode2226    每个小孩最多能分到多少糖果
 * <二维矩阵二分>
 * @see LeetCode74      搜索二维矩阵
 * @see LeetCode240     搜索二维矩阵 II
 * @see LeetCode378     有序矩阵中第 K 小的元素
 * <浮点数>
 * @see LeetCode3453    分割正方形 I
 */
public interface BinarySearch {

    // 寻找 x
    default int bs(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == x) return mid;
            if (a[mid] < x) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    // 第一个>=x的数
    default int findL(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] < x) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    // 最后一个<=x的数
    default int findR(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (a[mid] > x) r = mid - 1;
            else l = mid;
        }
        return l;
    }

    default double bsearch(double l, double r) {
        double eps = 1e-6;  // eps 表示精度，取决于题目对精度的要求
        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (check(mid)) r = mid;
            else l = mid;
        }
        return l;
    }

    default boolean check(double mid) {
        return false;
    }

    // ================= 二分答案 (Binary Search on Answer) =================
    // 把"求最优解"转化为"判定某个候选答案是否可行"。答案关于可行性单调时可二分。
    // 求最小可行答案：在值域 [lo, hi] 上找第一个使 feasible 为 true 的值。
    default long minFeasible(long lo, long hi) {
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (feasible(mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    // 求最大可行答案：找最后一个使 feasible 为 true 的值。
    default long maxFeasible(long lo, long hi) {
        while (lo < hi) {
            long mid = lo + (hi - lo + 1) / 2;
            if (feasible(mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    // 判定候选答案 x 是否可行，具体题目重写此逻辑。
    default boolean feasible(long x) {
        return false;
    }

    // ================= 二维矩阵二分 =================
    // 每行升序、每列升序的矩阵中查找 target：从右上角开始，大则左移、小则下移，O(m+n)。
    default boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int v = matrix[row][col];
            if (v == target) return true;
            if (v > target) col--;
            else row++;
        }
        return false;
    }
}
