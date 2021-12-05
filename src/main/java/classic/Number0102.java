package classic;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jingxinwu
 * @date 2021-12-05 12:38 下午
 */
public class Number0102 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }

        if (s1 == null) {
            return false;
        }
        if (s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            if (map1.containsKey(c)) {
                int old = map1.get(c);
                map1.put(c, old + 1);
            } else {
                map1.put(c, 1);
            }

        }
        for (Character c : s2.toCharArray()) {
            if (map2.containsKey(c)) {
                int old = map2.get(c);
                map2.put(c, old + 1);
            } else {
                map2.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> en : map1.entrySet()) {
            Character key = en.getKey();
            if (!map2.containsKey(key)) {
                return false;
            }
            if (!Objects.equals(map2.get(key), map1.get(key))) {
                return false;
            }
        }

        return true;
    }

}
