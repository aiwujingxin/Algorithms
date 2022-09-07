package basicKnowledge.algorithm.sort;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wu.wjx
 * @date: 2020-12-23 14:56
 **/
public class Sort {

    private static void bucketSort(int[] arr) {
        int minVal = arr[0];
        int maxVal = arr[0];
        for (int item : arr) {
            if (item < minVal) {
                minVal = item;
            } else if (item > maxVal) {
                maxVal = item;
            }
        }
        int bucketNum = (maxVal - minVal) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }

        for (int value : arr) {
            int num = (value - minVal) / arr.length;
            bucketArr.get(num).add(value);
        }
        for (ArrayList<Integer> integers : bucketArr) {
            Collections.sort(integers);
        }

        int ndx = 0;
        for (ArrayList<Integer> list : bucketArr) {
            for (Integer n : list) {
                arr[ndx++] = n;
            }
        }
    }

    List<List<Integer>> tempArray = new LinkedList<>();

    private void radixSort(int[] nums) {
        for (int i = 0; i < 10; i++) {
            tempArray.add(new ArrayList<>());
        }
        int maxLength = getMaxLength(nums);
        for (int i = 0; i < maxLength; i++) {
            for (List<Integer> listArr : tempArray) {
                listArr.clear();
            }
            for (int ele : nums) {
                int temp = getIndexNumber(ele, i);
                tempArray.get(temp).add(ele);
            }
            copyFromTemp(nums);
        }
    }

    void copyFromTemp(int[] arr) {
        int index = 0;
        for (List<Integer> item : tempArray) {
            for (Integer intNum : item) {
                arr[index++] = intNum;
            }
        }
    }

    static int getIndexNumber(int num, int index) {
        if (index != 0) {
            num /= index * 10;
        }
        return num % 10;
    }


    /**
     * 获取最高位数
     */
    private static int getMaxLength(int[] nums) {
        int maxValue = nums[0];
        for (int value : nums) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        if (maxValue == 0) {
            return 1;
        }
        int length = 0;
        for (long temp = maxValue; temp != 0; temp /= 10) {
            length++;
        }
        return length;
    }


    private static void heapSort(int[] nums) {
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

    private static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    private static void merge(int[] nums, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = nums[l + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = nums[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }


    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int i, int j) {
        if (i < j) {
            int index = part(nums, i, j);
            quickSort(nums, i, index - 1);
            quickSort(nums, index + 1, j);
        }
    }

    private static int part(int[] nums, int i, int j) {
        int pi = nums[i];
        while (i < j) {
            while (nums[j] >= pi && i < j) {
                j--;
            }
            nums[i] = nums[j];
            while (nums[i] <= pi && i < j) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pi;
        return i;
    }

    private static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            int temp = nums[index];
            for (int j = index; j < nums.length; j++) {
                if (nums[j] < temp) {
                    index = j;
                }
            }
            int n = nums[index];
            nums[i] = nums[index];
            nums[index] = n;
        }
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    private static void shellSort(int[] nums) {
        for (int dk = nums.length / 2; dk >= 1; dk /= 2) {
            for (int i = dk; i < nums.length; i++) {
                int j = i - dk;
                int temp = nums[i];
                while (j >= 0 && nums[j] > temp) {
                    nums[j + dk] = nums[j];
                    j = j - dk;
                }
                nums[j + dk] = temp;
            }
        }
    }

    private static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i - 1;
            int temp = nums[i];
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }
}
