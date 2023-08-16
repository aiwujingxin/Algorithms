package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/2 14:32
 */
public class LeetCode702 {
    private static final int MAX_LENGTH = 20000;

    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = MAX_LENGTH - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = reader.get(mid);

            if (midValue < target) {
                left = mid + 1;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    interface ArrayReader {
        int get(int index);
    }
}
