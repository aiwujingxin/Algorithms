package classic;

import java.util.HashSet;

/**
 * @author jingxinwu
 * @date 2021-12-05 12:36 下午
 */
public class Number0101 {

    public boolean isUnique(String astr) {

        if (astr == null || astr.length() == 0) {
            return true;
        }

        HashSet<Character> s = new HashSet<>();

        for (Character c : astr.toCharArray()) {
            if (s.contains(c)) {
                return false;
            }
            s.add(c);
        }

        return false;

    }

}
