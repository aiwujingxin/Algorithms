package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/6 23:19
 */
public class LeetCode786_bs {

    int x;
    int y;

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0.0, right = 1.0;
        while (true) {
            double mid = left + (right - left) / 2;
            x = 0;
            y = 1;
            int cnt = cntNoGreaterThanMid(arr, mid);
            if (cnt < k) {
                left = mid;
            } else if (cnt == k) {
                return new int[]{x, y};
            } else {
                right = mid;
            }
        }
    }

    public int cntNoGreaterThanMid(int[] arr, double mid) {
        int i, j = arr.length - 1;
        int cnt = 0;
        for (; j > 0; j--) {
            i = j - 1;
            while (i >= 0 && (double) arr[i] / arr[j] > mid) {
                i--;
            }
            cnt += i + 1;
            if (i >= 0 && arr[i] * y > arr[j] * x) {
                x = arr[i];
                y = arr[j];
            }
        }
        return cnt;
    }
}

