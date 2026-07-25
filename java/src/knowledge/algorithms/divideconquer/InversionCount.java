package knowledge.algorithms.divideconquer;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 归并求逆序对 (Merge Sort Inversion Count)
 * <适用场景>
 * 统计 i<j 且 a[i]>a[j] 的对数（逆序对 / 翻转对），是分治统计的经典范例。
 * <核心>
 * 归并排序合并两段时，若左段当前元素大于右段元素，则左段剩余元素都与之构成逆序对，
 * 一次合并即可累加跨越中线的贡献，总复杂度 O(n log n)。
 * @see knowledge.algorithms.sort.comparison.MergeSort 归并排序本体
 */
public class InversionCount {

    /**
     * 返回数组的逆序对总数（会创建副本，不改变原数组）。
     */
    public static long count(int[] nums) {
        int[] arr = nums.clone();
        int[] temp = new int[arr.length];
        return mergeCount(arr, temp, 0, arr.length - 1);
    }

    private static long mergeCount(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) >>> 1;
        long count = mergeCount(arr, temp, left, mid) + mergeCount(arr, temp, mid + 1, right);
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // arr[i..mid] 都大于 arr[j]，一次性累加
                count += mid - i + 1;
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        System.arraycopy(temp, left, arr, left, right - left + 1);
        return count;
    }
}
