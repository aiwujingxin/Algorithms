package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author jingxinwu
 * @date 2021-11-21 10:30 下午
 */
public class LeetCode658 {


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //custom sort function
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a - x) == Math.abs(b - x)) {
                return a - b;
            } else {
                return Math.abs(a - x) - Math.abs(b - x);
            }
        });

        for (int j : arr) {
            queue.add(j);
        }

        List<Integer> lst = new ArrayList<>();
        while (k > 0) {
            lst.add(queue.remove());
            k--;
        }
        Collections.sort(lst);
        return lst;
    }


    public List<Integer> findClosestElementsV2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();  // A list to store the resultant subarray
        int low = 0;                                    // A var to point at the left half of the array
        int high = arr.length - 1;                      // A var to point at the right half of the array

        // Traverse till the difference between 'high' and 'low' is not less than 'k'
        while (high - low >= k) {
            // Get the difference between 'x' and the element at index 'low' in 'distLow'
            int distLow = Math.abs(arr[low] - x);
            // Get the difference between 'x' and the element at index 'high' in 'distHigh'
            int distHigh = Math.abs(arr[high] - x);

            // Now, check if 'distLow' less than or equal 'distHigh' or not
            if (distLow <= distHigh) {
                // If Yes, then move the right pointer i.e., decrease the value of 'high'
                high--;
            } else {
                // Move the left pointer i.e., increase the value of 'low'
                low++;
            }
        }
        // After traversing the array, traverse another loop to get the resultant values
        while (low <= high) {
            list.add(arr[low++]);                       // And, keep adding those values to the resultant list
        }

        return list;                                    // Finally, return the resultant list
    }

}
