package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/22 00:20
 */
public class LeetCode38 {

    public static void main(String[] args) {
        System.out.println(new LeetCode38().countAndSay(7));
    }

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int index = 0;
            Character c = sb.toString().charAt(index);
            int count = 0;
            while (index < sb.length()) {
                if (sb.toString().charAt(index) == c) {
                    count++;
                    if (index == sb.length() - 1) {
                        temp.append(count).append(c);
                    }
                    index++;
                } else {
                    temp.append(count).append(c);
                    c = sb.toString().charAt(index);
                    count = 0;
                }
            }
            sb = temp;
        }
        return sb.toString();
    }
}
