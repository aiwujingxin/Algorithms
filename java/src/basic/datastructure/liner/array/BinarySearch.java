package basic.datastructure.liner.array;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 19:07
 */
public interface BinarySearch {
    //704. 二分查找 https://leetcode.cn/problems/binary-search/?envType=study-plan&id=binary-search-beginner&plan=binary-search&plan_progress=s4b8jr2
    //33. 搜索旋转排序数组 https://leetcode.cn/problems/search-in-rotated-sorted-array/
    //35. 搜索插入位置 https://leetcode.cn/problems/search-insert-position/?envType=study-plan&id=binary-search-beginner&plan=binary-search&plan_progress=s4b8jr2
    //81. 搜索旋转排序数组 II https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
    // 搜索左/右边界

    // 209. 长度最小的子数组 https://leetcode.cn/problems/minimum-size-subarray-sum/?envType=study-plan&id=binary-search-basic&plan=binary-search&plan_progress=47rf0us
    int search(int[] nums, int target);

    //1539. 第 k 个缺失的正整数 https://leetcode.cn/problems/kth-missing-positive-number/?envType=study-plan&id=binary-search-beginner&plan=binary-search&plan_progress=s4b8jr2
    //719. 找出第 K 小的数对距离 https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
    int find(int[] nums, int k);

    //162. 寻找峰值 https://leetcode.cn/problems/find-peak-element/
    //153. 寻找旋转排序数组中的最小值 https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
    //268. 丢失的数字  https://leetcode.cn/problems/missing-number/
    //287. 寻找重复数 https://leetcode.cn/problems/find-the-duplicate-number/
    //852. 山脉数组的峰顶索引 https://leetcode.cn/problems/peak-index-in-a-mountain-array/
    //1027. 最长等差数列 https://leetcode.cn/problems/longest-arithmetic-subsequence/
    int find(int[] nums);

    //1855. 下标对中的最大距离  https://leetcode.cn/problems/maximum-distance-between-a-pair-of-values/
    int find(int[] nums1, int[] nums2);

    //367. 有效的完全平方数 https://leetcode.cn/problems/valid-perfect-square/
    //633. 平方数之和 https://leetcode.cn/problems/sum-of-square-numbers/
    int sqrt(int c);
}
