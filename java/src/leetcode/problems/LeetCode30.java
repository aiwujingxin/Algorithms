package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 20:35
 */
public class LeetCode30 {

    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int n = words.length;
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> tMap = new HashMap<>();
        for (String word : words) {
            tMap.put(word, tMap.getOrDefault(word, 0) + 1);
        }
        int target = tMap.size();
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int cnt = 0;
            HashMap<String, Integer> sMap = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String c = s.substring(right, right + wordLen);
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (Objects.equals(tMap.get(c), sMap.get(c))) {
                    cnt++;
                }
                while (right - left >= wordLen * (n - 1)) {
                    if (right - left == wordLen * (n - 1) && cnt == target) {
                        list.add(left);
                    }
                    String d = s.substring(left, left + wordLen);
                    if (Objects.equals(tMap.get(d), sMap.get(d))) {
                        cnt--;
                    }
                    sMap.put(d, sMap.get(d) - 1);
                    left += wordLen;
                }
                right += wordLen;
            }
        }
        return list;
    }
}
