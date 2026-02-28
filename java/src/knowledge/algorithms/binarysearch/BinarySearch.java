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
}
