package leetcode.problems;

import java.util.Comparator;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/22 15:55
 */
public class LeetCode524 {

    public String findLongestWord(String s, List<String> dictionary) {

        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
        });
        for (String t : dictionary) {
            if (check(t, s)) {
                return t;
            }
        }
        return "";
    }

    private boolean check(String t, String s) {
        int si = 0;
        int ti = 0;
        while (ti < t.length() && si < s.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
                ti++;
            } else {
                si++;
            }
        }
        return ti == t.length();
    }
}
