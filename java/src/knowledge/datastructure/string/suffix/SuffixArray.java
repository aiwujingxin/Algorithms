package knowledge.datastructure.string.suffix;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 11/9/24 06:47
 * @description 后缀数组 是一个整数数组，表示一个字符串的所有后缀在字典序下的排序结果。本质上是后缀树的空间优化版，用一个一维数组代替了复杂的树结构。
 * - 后缀数组是将所有后缀按字典序排序后的位置索引表，本质上是字符串后缀的有序索引。
 */

public class SuffixArray {
    public int[] sa;    // 后缀数组
    public int[] rank;  // 排名数组
    public int[] lcp;   // 最长公共前缀数组
    private String s;
    private int n;

    public SuffixArray(String s) {
        this.s = s;
        this.n = s.length();
        buildSuffixArray();
        buildLCPArray();
    }

    private void buildSuffixArray() {
        sa = new int[n];
        rank = new int[n];
        int[] temp = new int[n];
        Integer[] indices = new Integer[n];

        // 初始化
        for (int i = 0; i < n; i++) {
            indices[i] = i;
            rank[i] = s.charAt(i);
        }

        // 倍增法构建后缀数组
        for (int k = 1; k < n; k *= 2) {
            final int shift = k;
            Arrays.sort(indices, (a, b) -> {
                if (rank[a] != rank[b]) return Integer.compare(rank[a], rank[b]);
                int ra = (a + shift < n) ? rank[a + shift] : -1;
                int rb = (b + shift < n) ? rank[b + shift] : -1;
                return Integer.compare(ra, rb);
            });

            // 重新计算排名
            temp[indices[0]] = 0;
            for (int i = 1; i < n; i++) {
                temp[indices[i]] = temp[indices[i - 1]];
                if (rank[indices[i]] != rank[indices[i - 1]]) {
                    temp[indices[i]]++;
                } else {
                    int nextI = (indices[i] + shift < n) ? rank[indices[i] + shift] : -1;
                    int nextPrev = (indices[i - 1] + shift < n) ? rank[indices[i - 1] + shift] : -1;
                    if (nextI != nextPrev) {
                        temp[indices[i]]++;
                    }
                }
            }
            System.arraycopy(temp, 0, rank, 0, n);

            // 如果所有排名都不同，提前结束
            if (rank[indices[n - 1]] == n - 1) break;
        }

        // 将排序结果存入sa
        for (int i = 0; i < n; i++) {
            sa[i] = indices[i];
        }
    }

    private void buildLCPArray() {
        lcp = new int[n];
        int[] invSa = new int[n]; // 逆后缀数组：invSa[i] = 后缀s[i:]在sa中的位置

        for (int i = 0; i < n; i++) {
            invSa[sa[i]] = i;
        }

        int h = 0;
        for (int i = 0; i < n; i++) {
            if (invSa[i] == 0) {
                lcp[0] = 0;
                continue;
            }

            int j = sa[invSa[i] - 1]; // 前一个后缀的起始位置
            while (i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)) {
                h++;
            }
            lcp[invSa[i]] = h;

            if (h > 0) h--;
        }
    }

    // 二分查找模式串（更高效）
    public boolean contains(String pattern) {
        int left = 0, right = n - 1;
        int m = pattern.length();

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int cmp = compare(sa[mid], pattern, m);

            if (cmp == 0) return true;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    // 比较后缀和模式串（避免创建子字符串）
    private int compare(int suffixStart, String pattern, int patternLength) {
        int minLen = Math.min(n - suffixStart, patternLength);
        for (int i = 0; i < minLen; i++) {
            char c1 = s.charAt(suffixStart + i);
            char c2 = pattern.charAt(i);
            if (c1 != c2) return c1 - c2;
        }
        return (n - suffixStart) - patternLength;
    }

    // 查找模式串的所有出现位置
    public int[] findAllOccurrences(String pattern) {
        int left = findLeftBound(pattern);
        int right = findRightBound(pattern);

        if (left > right) return new int[0];

        int[] occurrences = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            occurrences[i - left] = sa[i];
        }
        Arrays.sort(occurrences); // 按位置排序
        return occurrences;
    }

    private int findLeftBound(String pattern) {
        int left = 0, right = n - 1;
        int m = pattern.length();
        int result = n;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int cmp = compare(sa[mid], pattern, m);

            if (cmp >= 0) {
                if (cmp == 0) result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private int findRightBound(String pattern) {
        int left = 0, right = n - 1;
        int m = pattern.length();
        int result = -1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int cmp = compare(sa[mid], pattern, m);

            if (cmp <= 0) {
                if (cmp == 0) result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // 最长重复子串
    public String longestRepeatedSubstring() {
        int maxLength = 0;
        int startIndex = 0;

        for (int i = 1; i < n; i++) {
            if (lcp[i] > maxLength) {
                maxLength = lcp[i];
                startIndex = sa[i];
            }
        }

        return maxLength > 0 ? s.substring(startIndex, startIndex + maxLength) : "";
    }

    // 打印后缀数组信息
    public void print() {
        System.out.println("Index\tSA\tLCP\tSuffix");
        for (int i = 0; i < n; i++) {
            String suffix = (sa[i] + 20 < n) ? s.substring(sa[i], Math.min(sa[i] + 20, n)) + "..." : s.substring(sa[i]);
            System.out.printf("%d\t%d\t%d\t%s\n", i, sa[i], lcp[i], suffix);
        }
    }

    public static void main(String[] args) {
        String text = "banana";
        SuffixArray sa = new SuffixArray(text);
        sa.print();

        System.out.println("\nContains 'ana': " + sa.contains("ana"));
        System.out.println("Contains 'apple': " + sa.contains("apple"));
        System.out.println("Longest repeated substring: '" + sa.longestRepeatedSubstring() + "'");

        int[] occurrences = sa.findAllOccurrences("ana");
        System.out.println("Occurrences of 'ana': " + Arrays.toString(occurrences));
    }
}