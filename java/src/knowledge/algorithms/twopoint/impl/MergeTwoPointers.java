package knowledge.algorithms.twopoint.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 归并双指针 (Merge Two Pointers)
 * <适用场景>
 * 两个有序序列的合并、有序数组平方、逆向原地归并。核心是两个指针各扫一遍，按大小推进。
 * <核心>
 * 正向合并从小端取；逆向归并从大端往 nums1 尾部填，避免覆盖未处理元素。
 */
public class MergeTwoPointers {

    /**
     * 合并两个升序数组为一个新升序数组。
     */
    public int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            result[k++] = a[i] <= b[j] ? a[i++] : b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }

    /**
     * 将升序 nums2 逆向原地归并进有 m 个有效元素、总长 m+n 的 nums1（LeetCode 88）。
     */
    public void mergeInPlace(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    /**
     * 升序数组各元素平方后的升序结果，双端向中间取较大值倒序填充（LeetCode 977）。
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        for (int k = n - 1; k >= 0; k--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[k] = leftSquare;
                left++;
            } else {
                result[k] = rightSquare;
                right--;
            }
        }
        return result;
    }
}
