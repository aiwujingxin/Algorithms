package leetcode.lists.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 16:11
 */
public class LCR135 {

    List<String> result;
    int n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LCR135().printNumbers(3)));
    }

    public int[] printNumbers(int n) {
        this.n = n;
        result = new ArrayList<>(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs(0, new StringBuilder()); // 开启全排列递归
        int[] arr = new int[result.size() - 1];
        for (int i = 1; i < result.size(); i++) {
            arr[i - 1] = Integer.parseInt(result.get(i));
        }
        return arr; // 转化为字符串并返回
    }

    void dfs(int x, StringBuilder sb) {
        if (x == n) { // 终止条件：已固定完所有位
            result.add(sb.toString()); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for (char i : loop) { // 遍历 ‘0‘ - ’9‘
            sb.append(i);
            dfs(x + 1, sb); // 开启固定第 x + 1 位
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
