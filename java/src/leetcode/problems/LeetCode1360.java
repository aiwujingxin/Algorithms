package leetcode.problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 18:57
 */
public class LeetCode1360 {

    public int daysBetweenDates(String date1, String date2) {
        LocalDate localDate1 = LocalDate.parse(date1);
        LocalDate localDate2 = LocalDate.parse(date2);
        return Math.abs((int) ChronoUnit.DAYS.between(localDate1, localDate2));
    }
}
