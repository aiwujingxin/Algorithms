package newker;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[]{98, 5, 2, 3, 1, 4, 99};
        System.out.println(Arrays.toString(MySort(arr)));
    }

    public static int[] MySort(int[] arr) {
        // write code here

        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public static int[] sort(int[] arr, int i, int j) {
        if (i < j) {
            int index = part(arr, i, j);
            sort(arr, i, index - 1);
            sort(arr, index + 1, j);
        }

        return arr;
    }


    public static int part(int[] arr, int i, int j) {

        int pi = arr[i];
        while (i < j) {
            while (arr[j] >= pi && i < j) {
                j--;
            }
            arr[i] = arr[j];
            while (arr[i] <= pi && i < j) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pi;
        return i;
    }

}
