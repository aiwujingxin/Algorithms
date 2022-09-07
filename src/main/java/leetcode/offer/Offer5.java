package leetcode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-19 9:24 下午
 */
public class Offer5 {


    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
    
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else {
                sb.append("%20");
            }

        }
        return sb.toString();
    }
}
