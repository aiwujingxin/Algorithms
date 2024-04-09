package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/15 20:27
 */
public class LeetCode1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = words.length;
        int[] arr = new int[n];
        for (int w = 0; w < words.length; w++) {
            arr[w] = getCnt(words[w]);
        }
        Arrays.sort(arr);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cnt = getCnt(queries[i]);
            res[i] = arr.length - 1 - leftBound(arr, cnt);
        }
        return res;
    }

    public int leftBound(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        if (arr[l] <= target) {
            return arr.length;
        }
        return l;
    }

    public int getCnt(String s) {
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
        }
        for (int anInt : ints) {
            if (anInt != 0) {
                return anInt;
            }
        }
        return 0;
    }
}

