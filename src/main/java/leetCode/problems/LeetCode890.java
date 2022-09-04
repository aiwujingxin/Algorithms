package leetCode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/13 21:25
 */
public class LeetCode890 {


    public static void main(String[] args) {
        System.out.println(new LeetCode890().findAndReplacePattern(
                new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        for (String s : words) {
            if (check(s, pattern)) {
                list.add(s);
            }
        }

        return list;
    }

    private boolean check(String s, String pattern) {
        if (s.length() != pattern.length()) {
            return false;
        }

        HashMap<Character, Character> first = new HashMap<>();
        HashMap<Character, Character> second = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (first.get(s.charAt(i)) == null) {
                if (second.get(pattern.charAt(i)) != null && !second.get(pattern.charAt(i)).equals(s.charAt(i))) {
                    return false;
                }
                first.put(s.charAt(i), pattern.charAt(i));
                second.put(pattern.charAt(i), s.charAt(i));
            } else {
                Character sc = first.get(s.charAt(i));
                if (!sc.equals(pattern.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
