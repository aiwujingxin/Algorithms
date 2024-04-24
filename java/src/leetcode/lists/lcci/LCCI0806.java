package leetcode.lists.lcci;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/24 21:54
 */
public class LCCI0806 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(), A, B, C);
    }

    public void hanota(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        hanota(size - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        hanota(size - 1, B, A, C);
    }
}
