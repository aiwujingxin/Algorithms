package competition.weekly.week274;

/**
 * @author jingxinwu
 * @date 2022-01-02 10:31 AM
 */
public class LeetCode5967 {

    public static void main(String[] args) {
        System.out.println(new LeetCode5967().checkString("abab"));
    }

    public boolean checkString(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (c == 'a') {
                count++;
            }
        }
        int t = 0;
        for (Character c : s.toCharArray()) {
            if (c == 'b') {
                break;
            }
            t++;
        }
        return count == t;
    }
}
