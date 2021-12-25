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
            //待排序的数
            int num = arr[i];
            //j 用来找待排序的数
            int j = i - 1;
            //当j位于比num 的数停止
            while (j >= 0 && num < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            //j向后 + 1 位，是num排序好的位置
            arr[j + 1] = num;
        }
    }
}
