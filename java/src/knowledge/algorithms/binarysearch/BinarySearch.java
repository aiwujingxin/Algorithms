package knowledge.algorithms.binarysearch;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:27
 * @description 二分查找
 * <基础>
 * @see LeetCode704 704. 二分查找
 * @see LeetCode34
 * @see LeetCode35 35. 搜索插入位置
 * @see LeetCode33 33. 搜索旋转排序数组
 * @see LeetCode81 81. 搜索旋转排序数组 II
 * <find>
 * @see LeetCode153 153. 寻找旋转排序数组中的最小值
 * @see LeetCode162 162. 寻找峰值
 * @see LeetCode268 268. 丢失的数字
 * @see LeetCode852 852. 山脉数组的峰顶索引
 * @see LeetCode367 367. 有效的完全平方数
 * @see LeetCode1855 1855. 下标对中的最大距离
 * <find k>
 * @see LeetCode1539 1539. 第 k 个缺失的正整数
 * @see LeetCode719 719. 找出第 K 小的数对距离
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
    default int leftBound(int[] a, int x) {
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
    default int rightBound(int[] a, int x) {
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
