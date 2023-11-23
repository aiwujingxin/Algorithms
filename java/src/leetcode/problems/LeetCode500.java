package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-01-10 11:34 PM
 */
public class LeetCode500 {

    static String[] ss = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    static int[] hash = new int[26];

    static {
        for (int i = 0; i < ss.length; i++) {
            for (char c : ss[i].toCharArray()) {
                hash[c - 'a'] = i;
            }
        }
    }

    public String[] findWords(String[] words) {

        if (words == null || words.length == 0) {
            return new String[]{};
        }
        String one = "qwertyuiop";
        String two = "asdfghjkl";
        String three = "zxcvbnm";
        List<HashSet<Character>> list = new ArrayList<>();
        HashSet<Character> set1 = new HashSet<>();
        for (int i = 0; i < one.length(); i++) {
            set1.add(one.charAt(i));
        }
        list.add(set1);
        HashSet<Character> set2 = new HashSet<>();
        for (int i = 0; i < two.length(); i++) {
            set2.add(two.charAt(i));
        }
        list.add(set2);
        HashSet<Character> set3 = new HashSet<>();
        for (int i = 0; i < three.length(); i++) {
            set3.add(three.charAt(i));
        }
        list.add(set3);

        List<String> res = new ArrayList<>();
        for (String s : words) {
            if (canAdd(list, s)) {
                res.add(s);
            }
        }
        String[] strs = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            strs[i] = res.get(i);
        }
        return strs;
    }

    private boolean canAdd(List<HashSet<Character>> list, String s) {
        for (HashSet<Character> set : list) {
            int index = 0;
            while (index < s.length() && set.contains(Character.toLowerCase(s.charAt(index)))) {
                index++;
            }
            if (index - 1 == s.length() - 1) {
                return true;
            }
        }
        return false;
    }

    //妙
    public String[] findWordsV2(String[] words) {
        List<String> list = new ArrayList<>();
        out:
        for (String w : words) {
            int t = -1;
            for (char c : w.toCharArray()) {
                c = Character.toLowerCase(c);
                if (t == -1) {
                    t = hash[c - 'a'];
                } else if (t != hash[c - 'a']) {
                    continue out;
                }
            }
            list.add(w);
        }
        return list.toArray(new String[list.size()]);
    }
}

