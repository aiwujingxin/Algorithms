package sort;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-06-06 4:45 下午
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 2, 8, 9, 3, 6, 8, 2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int j = i - 1;
            while (j >= 0 && num < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = num;
        }
    }
}
