package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/3 15:50
 */

func hanota(A []int, B []int, C []int) []int {

	if A == nil {
		return nil
	}

	move(len(A), &A, &B, &C)
	return C
}

func move(n int, A *[]int, B *[]int, C *[]int) {
	if n == 0 {
		return
	}
	if n == 1 { //最简问题处理：只有1个盘子，把盘子从A移动到C
		*C = append(*C, (*A)[len(*A)-1])
		*A = (*A)[:len(*A)-1]
	} else { //小一级问题处理。
		//把n个盘子从A通过B移动到C
		//1. 先把n-1个盘子从A通过C移动到B
		move(n-1, A, C, B)
		//2. 把A的最后一个盘子移动到C
		move(1, A, B, C)
		//3. 把n-1个盘子从B 通过A 移动到C
		move(n-1, B, A, C)
	}
}
