package LeetCode;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-12-12 5:22 PM
 */
public class LeetCode556 {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int nextGreaterElement(int n) {

        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;
        int[] arr = new int[len];
        int a = 0;
        while (n > 0) {
            arr[a] = (n % 10);
            n = n / 10;
            a++;
        }

        int i = 1;
        while (i < arr.length && arr[i] >= arr[i - 1]) {
            i++;
        }
        if (i == arr.length) {
            return -1;
        }

        int j = 0;
        while (j < arr.length & arr[j] <= arr[i]) {
            j++;
        }
        swap(arr, i, j);

        Arrays.sort(arr, 0, i);
        int[] temp = new int[i];
        System.arraycopy(arr, 0, temp, 0, i);
        for (int index = 0; index < i; index++) {
            arr[index] = temp[i - index - 1];
        }

        long sum = 0;

        for (int m = arr.length - 1; m >= 0; m--) {
            sum = sum * 10 + arr[m];
        }

        if (sum > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) sum;
    }
}
