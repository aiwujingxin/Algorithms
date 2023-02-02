package leetcode.lists.offer;

/**
 * @author jingxinwu
 * @date 2021-12-04 5:29 下午
 */
public class Offer51 {


    int count;
    int[] nums, tmp;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        MergeSort(nums, 0, nums.length - 1);
        return count;
    }

    int MergeSort(int[] arr, int l, int r) {
        int res = 0;
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
            // Sort first and second halves
            MergeSort(arr, l, m);

            MergeSort(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return res;
    }

    void merge(int[] arr, int l, int m, int r) {
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            tmp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = tmp[j++];
            } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
                count += m - i + 1; // 统计逆序对
            }
        }
    }
}
