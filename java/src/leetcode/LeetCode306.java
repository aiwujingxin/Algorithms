package leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-01-10 11:31 PM
 */
public class LeetCode306 {

    List<BigInteger> result = new ArrayList<>();
    String num;

    public boolean isAdditiveNumber(String num) {
        this.num = num;
        return DFS(0);
    }

    //从第0个位置开始
    private boolean DFS(int index) {
        if (index == num.length()) {
            return result.size() > 2;
        }
        //此次遍历的结尾
        int max = (num.charAt(index) == '0' ? index + 1 : num.length());
        for (int i = index + 1; i <= max; i++) {
            String temp = num.substring(index, i);
            if (result.size() < 2) {
                result.add(new BigInteger(temp));
            } else if (check(result.get(result.size() - 1), result.get(result.size() - 2), new BigInteger(temp))) {
                result.add(new BigInteger(temp));
            } else {
                continue;
            }

            if (DFS(i)) {
                return true;
            }
            result.remove(result.size() - 1);
        }
        return false;
    }

    private boolean check(BigInteger a, BigInteger b, BigInteger c) {
        return (a.add(b)).compareTo(c) == 0;
    }

    public boolean isAdditiveNumberV2(String num) {
        for (int i = 1; i <= num.length() - 2; ++i) {
            for (int j = i + 1; j <= num.length() - 1; ++j) {
                if (driverUtill(num, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean driverUtill(String num, int start, int mid, int end) {
        if ((num.charAt(mid) == '0' && end > mid + 1)) {
            return false;
        } else if (end == num.length()) {
            return true;
        }

        long nextNum = Long.parseLong(num.substring(start, mid)) + Long.parseLong(num.substring(mid, end));

        for (int i = end + 1; i <= num.length(); ++i) {
            long temp = Long.parseLong(num.substring(end, i));
            if (temp > nextNum) {
                return false;
            } else if (nextNum == temp && driverUtill(num, mid, end, i)) {
                return true;
            }
        }
        return false;
    }
}

