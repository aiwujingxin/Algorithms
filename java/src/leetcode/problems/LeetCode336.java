package leetcode.problems;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 20:15
 * @link <a href="https://www.youtube.com/watch?v=WPASktChEA4">...</a>
 */
public class LeetCode336 {

    TrieNode root = new TrieNode();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
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
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 剩余的部分是回文 且 前一部分的回文单词存在: xyzll + zyx
            if (isPalindrome(chars, i, chars.length - 1) && cur.wordIndex != -1) {
                res.add(Arrays.asList(wordIndex, cur.wordIndex));
            }

            if (cur.children[chars[i] - 'a'] == null) {
                return;
            }
            cur = cur.children[chars[i] - 'a'];
        }
        // 单词整体的回文单词存在 abcd + dcba
        // 注意: 避免和自己够成 aaa
        if (cur.wordIndex != -1 && cur.wordIndex != wordIndex) {
            res.add(Arrays.asList(wordIndex, cur.wordIndex));
        }

        // 单词整体的回文单词存在, 且那个单词剩余的部分是回文 "zyx" + ("llxyz" or "llllxyz")
        for (int index : cur.restIsPalindrome) {
            res.add(Arrays.asList(wordIndex, index));
        }
    }

    private void add(String word, int wordIndex) {
        TrieNode cur = root;
        char[] chars = word.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (isPalindrome(chars, 0, i)) {
                cur.restIsPalindrome.add(wordIndex);
            }
            if (cur.children[chars[i] - 'a'] == null) {
                cur.children[chars[i] - 'a'] = new TrieNode();
            }
            cur = cur.children[chars[i] - 'a'];
        }
        cur.wordIndex = wordIndex;
    }

    private boolean isPalindrome(char[] chs, int i, int j) {
        while (i < j) {
            if (chs[i++] != chs[j--]) {
                return false;
            }
        }
        return true;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordIndex = -1;
        List<Integer> restIsPalindrome = new ArrayList<>();
    }
}
