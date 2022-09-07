package leetcode.competition.doubleweekly.week69;

/**
 * @author jingxinwu
 * @date 2022-01-08 10:30 PM
 */
public class Number01 {

    public static void main(String[] args) {
        System.out.println(new Number01().capitalizeTitle("capiTalIze tHe titLe"));
    }

    public String capitalizeTitle(String title) {

        if (title == null || title.length() == 0) {
            return title;
        }
        StringBuilder sb = new StringBuilder();
        String[] strs = title.split(" ");
        for (String s : strs) {
            char[] newChar = new char[s.length()];
            if (s.length() == 1 || s.length() == 2) {
                for (int i = 0; i < s.length(); i++) {
                    newChar[i] = Character.toLowerCase(s.charAt(i));
                }
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (i == 0) {
                        newChar[i] = Character.toUpperCase(s.charAt(i));
                    } else {
                        newChar[i] = Character.toLowerCase(s.charAt(i));
                    }
                }
            }
            sb.append(newChar);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
