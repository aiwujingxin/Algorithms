package basic.datastructure.string.search;

import basic.datastructure.string.Search;
import leetcode.problems.LeetCode214;
import leetcode.problems.LeetCode28;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/4 22:47
 * @see LeetCode214
 * @see LeetCode28
 */

/*
* KMP 算法的主要思想是提前判断如何重新开始查找，而这种判断只取决于模式本身。
* https://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
  BBCABCDABABCDABCDABDE
                /|
               / |
              /  |
           ABCDABD
 * "部分匹配值"就是"前缀"和"后缀"的最长的共有元素的长度。
 * 移动位数 = 已匹配的字符数 - 对应的部分匹配值
 * 待匹配字符串中由于“AB ”刚匹配成功过, 可以维护一个前缀数组, 忽略开头的“AB”, 可以从第三位'C'开始匹配.
 * 对字符串A进行自我匹配，求出一个数组next，其中next 表示“A 以i结尾的非前缀子串”与“A的前缀” 能够匹配的最长长度。

 */

public class KMP implements Search {

    public int search(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        int[] next = makePrefix(pat);
        int i = 0;
        int j = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == M) {
                return i - j;
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    //prefix[i]表示对应的部分匹配值, s[i - prefix[i]] : i] == s[0: prefix[i]]
    public int[] makePrefix(String needle) {
        int[] prefix = new int[needle.length()];
        int i = 0, j = 1;
        while (j < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                prefix[j] = i + 1;
                i++;
                j++;
            } else {
                if (i - 1 >= 0) {
                    i = prefix[i - 1];
                } else {
                    prefix[j++] = 0;
                }
            }
        }
        return prefix;
    }
}
