package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/5/25 15:32
 */
public class LeetCode1287 {

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int j = 0;
            while (j < n && arr[j] == arr[i]) {
                j++;
            }
            if ((j - i + 1) * 4 > n) {
                return arr[i];
            }
            i = j + 1;
        }
        return -1;
    }
}
