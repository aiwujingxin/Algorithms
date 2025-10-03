package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/5/25 16:18
 */
public class LeetCode2337 {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length()) {
            return false;
        }
        char[] s = start.toCharArray();
        char[] t = target.toCharArray();
        if (start.equals(target)) return true;
        int n = start.length();
        int R1 = 0;
        int R2 = 0;
        int L1 = 0;
        int L2 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'L') L1++;
            if (s[i] == 'R') R1++;
            if (t[i] == 'L') L2++;
            if (t[i] == 'R') R2++;
        }
        if (L1 != L2 || R1 != R2) return false;

        return checkL(s, t) && checkR(s, t);
    }

    private boolean checkL(char[] start, char[] target) {
        int index1 = 0;
        int index2 = 0;
        int n = target.length;
        while (index2 < n) {
            int R2 = 0;
            int R1 = 0;
            while (index2 < n && target[index2] != 'L') {
                if (target[index2] == 'R') R2++;
                index2++;
            }
            if (index2 == n)
                return true;
            while (index1 < index2) {
                if (start[index1] == 'L') {
                    return false;
                }
                if (start[index1] == 'R') R1++;
                index1++;
            }
            if (index1 == n)
                return false;
            if (R1 != R2) return false;
            if (start[index1] == 'L') {
                index1++;
            } else {
                int cur = index1;
                while (cur < n) {
                    if (start[cur] == '_') {
                        cur++;
                    } else {
                        break;
                    }
                }
                if (cur == n || start[cur] != 'L') {
                    return false;
                }
                index1 = cur + 1;
            }
            index2++;
        }
        return true;
    }

    private boolean checkR(char[] start, char[] target) {
        int n = target.length;
        int index1 = n - 1;
        int index2 = n - 1;
        while (index2 >= 0) {
            int L2 = 0;
            int L1 = 0;
            while (index2 >= 0 && target[index2] != 'R') {
                if (target[index2] == 'L') L2++;
                index2--;
            }
            if (index2 == -1)
                return true;
            while (index1 > index2) {
                if (start[index1] == 'R') {
                    return false;
                }
                if (start[index1] == 'L') L1++;
                index1--;
            }
            if (L1 != L2) return false;
            if (index1 == -1)
                return false;
            if (start[index1] == 'R') {
                index1--;
            } else {
                int cur = index1;
                while (cur >= 0) {
                    if (start[cur] == '_') {
                        cur--;
                    } else {
                        break;
                    }

                }
                if (cur < 0 || start[cur] != 'R') {
                    return false;
                }
                index1 = cur - 1;
            }
            index2--;
        }
        return true;
    }
}
