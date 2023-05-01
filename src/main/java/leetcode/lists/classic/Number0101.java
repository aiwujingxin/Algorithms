package leetcode.lists.classic;


/**
 * @author jingxinwu
 * @date 2021-12-05 12:36 下午
 */
public class Number0101 {

    public boolean isUnique(String astr) {
        if (astr == null || astr.length() == 0) {
            return true;
        }
        int checker = 0;
        for (Character c : astr.toCharArray()) {
            int index = c - 'a';
            if ((checker & (1 << index)) > 0) {
                return true;
            }
            checker |= (1 << index);
        }
        return false;
    }
}
