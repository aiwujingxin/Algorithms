package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/31 15:05
 */
public class LeetCode1904 {

    public int numberOfRounds(String loginTime, String logoutTime) {
        int cam = EL(Integer.parseInt(loginTime.substring(0, 2)), Integer.parseInt(loginTime.substring(3, 5)), Integer.parseInt(logoutTime.substring(0, 2)), Integer.parseInt(logoutTime.substring(3, 5)));
        if (cam == 0) {
            return 0;
        }
        if (cam < 0) {
            return cal(loginTime, logoutTime);
        }
        return cal(loginTime, "24:00") + cal("00:00", logoutTime);
    }

    private int cal(String loginTime, String logoutTime) {
        int shour = Integer.parseInt(loginTime.substring(0, 2));
        int sminute = Integer.parseInt(loginTime.substring(3, 5));
        int ehour = Integer.parseInt(logoutTime.substring(0, 2));
        int eminute = Integer.parseInt(logoutTime.substring(3, 5));

        sminute = sminute % 15 == 0 ? sminute : (sminute / 15 + 1) * 15;
        if (sminute == 60) {
            shour++;
            sminute = 0;
        }
        int cnt = 0;
        while (EL(shour, sminute, ehour, eminute) <= 0) {
            sminute = sminute + 15;
            int cam = EL(shour, sminute, ehour, eminute);
            if (cam >= 0) {
                if (cam == 0) {
                    cnt++;
                }
                break;
            }
            cnt++;
            if (sminute == 60) {
                shour++;
                sminute = 0;
            }
        }
        return cnt;
    }

    private int EL(int shour, int sminute, int ehour, int eminute) {
        if (shour == ehour && sminute == eminute) {
            return 0;
        }
        if (shour > ehour) {
            return 1;
        }
        if (ehour > shour) {
            return -1;
        }
        if (sminute > eminute) {
            return 1;
        }
        return -1;
    }
}
