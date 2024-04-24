package knowledge.algorithms.divideconquer;

import knowledge.algorithms.sort.*;
import leetcode.lists.lcci.LCCI0806;
import leetcode.problems.LeetCode23;
import leetcode.problems.LeetCode324;
import leetcode.problems.LeetCode932;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 22:45
 * @description 分治
 * @see LCCI0806 汉诺塔
 * @see BubbleSort
 * @see InsertSort
 * @see SelectSort
 * @see MergeSort
 * @see QuickSort
 * @see LeetCode23
 * @see LeetCode324
 * @see LeetCode932
 */
public interface DivideConquer {

    /*divide(P) {
        if(P <= n) solve(P);// 解决小规模的问题
        divide P into smaller sub-instances P1 P2...Pk ; //分解问题
        for(int i = 1; i<= k;i++ ) {
            yi = divide(Pi); // 递归的解各个子问题
        }
        return merge(y1,y2..yk) //将各个子问题的解合并为原问题的解
    }*/
}
