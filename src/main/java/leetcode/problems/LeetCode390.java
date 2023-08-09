package leetcode.problems;

import java.util.*;

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

}
