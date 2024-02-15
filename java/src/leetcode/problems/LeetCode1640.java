package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/8 11:54
 */
public class LeetCode1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        int n = arr.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[index])) {
                int[] piece = map.get(arr[index]);
                for (int k : piece) {
                    if (arr[index] != k) {
                        return false;
                    }
                    index++;
                }
                if (index == arr.length) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return index == arr.length;
    }
}
