package leetCode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-27 2:53 下午
 */
public class Offer65 {

    //todo
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 转换成非进位和 + 进位
        return add(a ^ b, (a & b) << 1);
    }
}
