package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2022-02-17 6:12 PM
 */
public class LeetCode468 {

    public String validIPAddress(String queryIP) {

        if (queryIP == null || queryIP.isEmpty()) {
            return "Neither";
        }

        boolean is4 = checkIP4(queryIP);

        if (is4) {
            return "IPv4";
        }
        boolean is6 = checkIP6(queryIP);

        if (is6) {
            return "IPv6";
        }

        return "Neither";

    }

    private boolean checkIP6(String queryIP) {
        //fix -1
        String[] ip6s = queryIP.split(":", -1);
        //fix 8
        if (ip6s.length != 8) {
            return false;
        }

        for (String ip6 : ip6s) {

            if (ip6.isEmpty() || ip6.length() > 4) {
                return false;
            }

            for (char c : ip6.toCharArray()) {

                if ((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || Character.isDigit(c)) {
                    continue;
                }
                return false;
            }

        }
        return true;

    }

    private boolean checkIP4(String queryIP) {
        String[] ip4s = queryIP.split("\\.", -1);

        if (ip4s.length != 4) {
            return false;
        }
        for (String ip4 : ip4s) {
            //fix
            if (ip4.length() < 1 || ip4.length() > 3) {
                return false;
            }

            //fix
            if (ip4.charAt(0) == '0' && ip4.length() != 1) {
                return false;
            }

            //fix
            for (char ch : ip4.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return false;
                }
            }

            int num = Integer.parseInt(ip4);
            if (num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }

}
