package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-01-02 12:51 AM
 */
public class LeetCode390 {

    public static void main(String[] args) {
        System.out.println(new LeetCode390().lastRemaining(9));
    }

    public int lastRemaining(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        while (array.length > 1) {
            for (int x = 0; x < array.length; x = x + 2) {
                array[x] = -1;
            }
            List<Integer> list = new ArrayList<>();
            for (int a : array) {
                if (a > 0) {
                    list.add(a);
                }
            }

            if (list.size() == 1) {
                return list.get(0);
            }

            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }

            list.clear();
            for (int y = arr.length - 1; y >= 0; y = y - 2) {
                arr[y] = -1;
            }
            for (int num : arr) {
                if (num > 0) {
                    list.add(num);
                }
            }

            if (list.size() == 1) {
                return list.get(0);
            }

            int[] b = new int[list.size()];

            for (int i = 0; i < list.size(); i++) {
                b[i] = list.get(i);
            }
            array = b;

        }
        return array[0];
    }

    public int lastRemainingv2(int n) {
        int a1 = 1, an = n;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) { // 正向
                a1 = a1 + step;
                an = (cnt % 2 == 0) ? an : an - step;
            } else { // 反向
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
                an = an - step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }
}
