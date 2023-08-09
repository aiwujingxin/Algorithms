package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 16:24
 */
public class LeetCode243 {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
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
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int[] res = search(b, a[i]);
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
}
