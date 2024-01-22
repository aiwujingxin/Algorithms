package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 22:48
 */
public class LeetCode2451 {

    public String oddString(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        if (words.length == 2) {
            return words[0];
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String w : words) {
            String d = getDiff(w);
            List<String> list = map.getOrDefault(d, new ArrayList<>());
            list.add(w);
            map.put(d, list);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                return entry.getValue().get(0);
            }
        }
        return "";
    }

    private String getDiff(String w) {
        StringBuilder d = new StringBuilder();
        for (int i = 1; i < w.length(); i++) {
            d.append(w.charAt(i) - w.charAt(i - 1));
            d.append(",");
        }
        return d.toString();
    }
}
