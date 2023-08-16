package leetcode.lists.offer;

import java.util.Arrays;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-11-21 2:29 下午
 */
public class Offer17 {

    StringBuilder res;
    int n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        this.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs(0); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
        List<String> result = Arrays.asList(res.toString().split(","));

        int[] arr = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            arr[i] = Integer.parseInt(result.get(i));
        }
        return arr; // 转化为字符串并返回
    }

    void dfs(int x) {
        if (x == n) { // 终止条件：已固定完所有位
            res.append(String.valueOf(num)).append(","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for (char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            dfs(x + 1); // 开启固定第 x + 1 位
        }
    }
}
