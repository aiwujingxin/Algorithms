package newker;

import java.util.ArrayList;
import java.util.List;

public class GetLeastNumbers {

    public static void main(String[] args) {
        GetLeastNumbers test = new GetLeastNumbers();
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println((test.getLeastNumbers(arr, 10)));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length < k) {
            return list;
        }
        fastSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void fastSort(int[] array, int start, int tail) {
        if (start >= tail) {
            return;
        }
        //将第一个元素作为比较元素，从第二个开始到最后一个执行快速排序算法
        int begin = start;
        int end = tail;
        int key = array[start];
        while (begin < end) {
            while (array[end] >= key && begin < end) {
                end = end - 1;
            }
            while (array[begin] <= key && begin < end) {
                begin = begin + 1;
            }
            if (end > begin) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }
        array[start] = array[begin];
        array[begin] = key;
        fastSort(array, start, begin - 1);
        fastSort(array, begin + 1, tail);
    }


    public List<Integer> getLeastNumbers(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = partitionV2(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }


    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private int partitionV2(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (nums[r] >= pivot && l < r) {
                r--;
            }
            nums[l] = nums[r];
            while (nums[l] <= pivot && l < r) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l + 1;
    }
}



