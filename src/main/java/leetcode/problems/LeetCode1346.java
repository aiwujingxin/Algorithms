package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 17:52
 */
public class LeetCode1346 {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int l = 0;
            int r = arr.length - 1;
            int target = arr[i] * 2;
            int index = find(arr, target, l, r);
            if (index != -1 && i != index) {
                return true;
            }
        }
        return false;
    }


    private int find(int[] arr, int target, int start, int end) {
        int l = start;
        int r = end;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
