package leetCode.problems;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/9 20:39
 */
public class LeetCode336_v1 {

    //https://www.youtube.com/watch?v=WPASktChEA4

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordIndex = -1;
        List<Integer> restIsPalindrome;

        TrieNode() {
            restIsPalindrome = new ArrayList<>();
        }
    }

    TrieNode root = new TrieNode();
    int n;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        n = words.length;

        for (int i = 0; i < n; i++) {
            add(words[i], i);
        }

        for (int i = 0; i < n; i++) {
            search(words[i], i);
        }

        return res;
    }

    private void search(String word, int wordIndex) {
        TrieNode cur = root;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int j = chs[i] - 'a';
            //cur.wordIndex != -1 是否能走到这个字符
            if (cur.wordIndex != -1 && isPalindrome(chs, i, chs.length - 1)) {// xyzll   zyx
                // 剩余的是回文的话 ，就不用看了
                res.add(Arrays.asList(wordIndex, cur.wordIndex));
            }
            if (cur.children[j] == null) {
                return;
            }
            cur = cur.children[j];
        }

        // aaaa 避免和自己够成
        if (cur.wordIndex != -1 && cur.wordIndex != wordIndex) {
            res.add(Arrays.asList(wordIndex, cur.wordIndex));
        }


        // 当前存放的 剩余的都是restIsPalindrome 的list "zyx" |   "llxyz" or "llllxyz"
        // zyx 已经走结束了，就看剩下的回文数 比如ll
        for (int j : cur.restIsPalindrome) {
            res.add(Arrays.asList(wordIndex, j));
        }
    }

    private void add(String word, int wordIndex) {
        TrieNode cur = root;
        char[] chs = word.toCharArray();
        for (int i = chs.length - 1; i >= 0; i--) {
            int j = chs[i] - 'a';
            if (isPalindrome(chs, 0, i)) {
                cur.restIsPalindrome.add(wordIndex);
            }

            if (cur.children[j] == null) {
                cur.children[j] = new TrieNode();
            }
            cur = cur.children[j];
        }

        cur.wordIndex = wordIndex;
    }

    private boolean isPalindrome(char[] chs, int i, int j) {
        while (i < j) {
            if (chs[i++] != chs[j--]) return false;
        }

        return true;
    }
}
