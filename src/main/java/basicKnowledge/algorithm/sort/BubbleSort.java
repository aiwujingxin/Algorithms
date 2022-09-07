package basicKnowledge.algorithm.sort;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-06-06 4:59 下午
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 2, 8, 9, 3, 6, 8, 2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}


