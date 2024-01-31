package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/30 11:43
 */
public class LeetCode1566 {

    public static void main(String[] args) {

        System.out.println(new LeetCode1566().containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 3));
    }

    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            String t = getStr(arr, i, i + m);
            map.put(t, 1);
            for (int j = i + m; j < n; j += m) {
                String tt = getStr(arr, j, j + m);
                if (!tt.equals(t)) {
                    break;
                }
                map.put(tt, map.getOrDefault(tt, 0) + 1);
            }
            if (map.get(t) >= k) {
                return true;
            }
        }
        return false;
    }

    private String getStr(int[] arr, int start, int end) {
        StringBuilder t = new StringBuilder();
        for (int x = start; x < Math.min(arr.length, end); x++) {
            t.append(arr[x]).append("_");
        }
        return t.toString();
    }

    public boolean containsPattern_fast(int[] arr, int m, int k) {
        int n = arr.length;
        for (int i = 0; i <= n - m * k; i++) {
            int j;
            for (j = 0; j < m * k; ++j) {
                if (arr[i + j] != arr[i + j % m]) {
                    break;
                }
            }
            if (j == m * k) {
                return true;
            }
        }
        return false;
    }
}

