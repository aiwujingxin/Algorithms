package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/16 23:03
 */
public class LeetCode2559 {

    HashSet<Character> set = new HashSet<>();

    public int[] vowelStrings(String[] words, int[][] queries) {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n = words.length;
        int[] arr = new int[n];
        for (int i = 0; i < words.length; i++) {
            arr[i] = check(words[i]) ? 1 : 0;
        }
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = sum[queries[i][1] + 1] - sum[queries[i][0]];
        }
        return res;
    }

    private boolean check(String word) {
        return (set.contains(word.charAt(0))) && set.contains(word.charAt(word.length() - 1));
    }
}
