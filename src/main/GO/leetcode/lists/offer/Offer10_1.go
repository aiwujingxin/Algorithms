package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 21:22
 */

func fib(n int) int {
	if n == 0 {
		return 0
	}
	var first int64
	var second int64
	first, second = 0, 1
	for i := 1; i <= n; i++ {
		t := first
		first = second
		second = (t + second) % 1000000007
	}
	return int(first % 1000000007)
}
