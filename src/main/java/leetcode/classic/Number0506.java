package leetcode.classic;

/**
 * @author jingxinwu
 * @date 2021-12-06 12:31 上午
 */
public class Number0506 {


    public int convertInteger(int A, int B) {
        //A与B进行异或运算，得到的结果1就是不相同，0就是相同
        //0011^1100 = 1111 结果有几个1，那么就有几个位要改变
        int temp = A ^ B, count = 0;
        while (temp != 0) {
            //temp&(temp -1) 可以把temp最右边的1置0，其余位不变
            //这样，这个操作执行了几次，就是有几位要转换
            temp = temp & (temp - 1);
            count++;
        }
        return count;
    }
}
