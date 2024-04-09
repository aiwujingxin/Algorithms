package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/2 14:32
 */
public class LeetCode702 {
    private static final int MAX_LENGTH = 20000;

    public int search(ArrayReader reader, int target) {
        int l = 0;
        int r = MAX_LENGTH - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = reader.get(mid);
            if (midValue < target) {
                l = mid + 1;
            } else if (midValue > target) {
                r = mid - 1;
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
