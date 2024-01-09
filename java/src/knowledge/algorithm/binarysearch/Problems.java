package knowledge.algorithm.binarysearch;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:27
 * @description 二分查找
 * 基础
 * @see LeetCode34
 * @see LeetCode57
 * @see LeetCode35 35. 搜索插入位置
 * @see LeetCode33 33. 搜索旋转排序数组
 * @see LeetCode81 81. 搜索旋转排序数组 II
 * @see LeetCode704 704. 二分查找
 * find k
 * @see LeetCode1539 1539. 第 k 个缺失的正整数
 * @see LeetCode719 719. 找出第 K 小的数对距离
 * find
 * @see LeetCode153 153. 寻找旋转排序数组中的最小值
 * @see LeetCode162 162. 寻找峰值
 * @see LeetCode268 268. 丢失的数字
 * @see LeetCode287 287. 寻找重复数
 * @see LeetCode852 852. 山脉数组的峰顶索引
 * @see LeetCode367 367. 有效的完全平方数
 * @see LeetCode1855 1855. 下标对中的最大距离
 */
public interface Problems {

    // 第一个大于等于target的数
    private int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 最后一个小于等于target的数
    private int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    default double bsearch_3(double l, double r) {
        double eps = 1e-6;  // eps 表示精度，取决于题目对精度的要求
        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    private boolean check(double mid) {
        return false;
    }

    // 寻找 target
    default int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
