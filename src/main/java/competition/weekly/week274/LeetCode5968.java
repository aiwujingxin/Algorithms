package competition.weekly.week274;

/**
 * @author jingxinwu
 * @date 2022-01-02 10:40 AM
 */
public class LeetCode5968 {

    public static void main(String[] args) {

        System.out.println(new LeetCode5968().numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
        System.out.println(new LeetCode5968().numberOfBeams(new String[]{"000", "111", "000"}));
    }

    public int numberOfBeams(String[] bank) {
        if (bank == null || bank.length == 0) {
            return 0;
        }
        int res = 0;
        int start = -1;
        while (start < bank.length) {
            int i = start + 1;
            int first = 0;
            while (i < bank.length) {
                if (count(bank[i]) != 0) {
                    first = count(bank[i]);
                    break;
                }
                i++;
            }
            int second = 0;
            int j = i + 1;
            //find next row
            while (j < bank.length) {
                if (count(bank[j]) != 0) {
                    second = count(bank[j]);
                    break;
                }
                j++;
            }
            res = res + first * second;
            start = j - 1;
        }
        return res;
    }

    private int count(String s) {
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
