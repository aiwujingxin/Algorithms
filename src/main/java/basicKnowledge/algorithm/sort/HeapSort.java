package basicKnowledge.algorithm.sort;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2022-02-17 10:21 PM
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 2, 8, 9, 3, 6, 8, 2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }

    }

    private static void heapify(int[] nums, int n, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int bigger = i;
        if (l < n && nums[l] > nums[bigger]) {
            bigger = l;
        }
        if (r < n && nums[r] > nums[bigger]) {
            bigger = r;
        }
        if (i != bigger) {
            int temp = nums[i];
            nums[i] = nums[bigger];
            nums[bigger] = temp;
            heapify(nums, n, bigger);
        }
    }

}
