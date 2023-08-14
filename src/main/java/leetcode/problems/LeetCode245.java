package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 17:00
 */
public class LeetCode245 {

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> bl = new ArrayList<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (Objects.equals(wordsDict[i], word1)) {
                al.add(i);
            } else if (word2.equals(wordsDict[i])) {
                bl.add(i);
            }
        }
        int[] a = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            a[i] = al.get(i);
        }
        int[] b = new int[bl.size()];
        for (int i = 0; i < bl.size(); i++) {
            b[i] = bl.get(i);
        }
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(a));

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int[] res;
            if (!word1.equals(word2)) {
                res = search(b, a[i]);
            } else {
                System.out.println(Arrays.toString(b));
                System.out.println(a[i]);
                res = searchTarget(b, a[i]);
            }
            min = Math.min(Math.min(Math.abs(a[i] - res[0]), Math.abs(a[i] - res[1])), min);

        }
        return min;
    }

    public int[] search(int[] b, int target) {
        int l = 0;
        int r = b.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (b[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (r == -1) {
            return new int[]{Integer.MAX_VALUE, b[l]};
        }
        if (l == b.length) {
            return new int[]{Integer.MAX_VALUE, b[r]};
        }
        return new int[]{b[l], b[r]};
    }

    public int[] searchTarget(int[] b, int target) {
        if (b.length == 1) {
            return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        }
        int l = 0;
        int r = b.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (b[mid] == target) {
                if (mid - 1 == -1) {
                    return new int[]{Integer.MAX_VALUE, b[mid + 1]};
                }
                if (mid + 1 == b.length) {
                    return new int[]{b[mid - 1], Integer.MAX_VALUE};
                }
            }
            if (b[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    }
}

