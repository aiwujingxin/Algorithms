package leetcode.lists.LCR;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 12:28
 */
public class LCR5 {

    HashMap<Integer, int[]> map;

    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int[] arr = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                arr[words[i].charAt(j) - 'a']++;
            }
            map.put(i, arr);
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (not(i, j)) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private boolean not(int i, int j) {
        int[] arr1 = map.get(i);
        int[] arr2 = map.get(j);
        for (int k = 0; k < 26; k++) {
            if (arr1[k] != 0 && arr2[k] != 0) {
                return false;
            }
        }
        return true;
    }

    //understand
    public int maxProduct_bit(String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                //将判断两个单词是否有公共字母的时间复杂度降低到 O(1)
                //通过位运算操作判断两个单词是否有公共字母
                //可以使用位掩码的最低 26 位分别表示每个字母是否在这个单词中出现
                masks[i] |= 1 << (c - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}

