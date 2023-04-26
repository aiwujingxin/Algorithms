package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 21:49
 */

func cuttingRope2(n int) int {

	if n <= 3 {
		return n - 1
	}
	ret := 1
	if n%3 == 1 {
		ret = 4
		n = n - 4
	}
	if n%3 == 2 {
		ret = 2
		n = n - 2
	}

	for n > 0 {
		ret = ret * 3 % 1000000007
		n -= 3
	}
	return ret
}
