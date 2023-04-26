package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/5 16:58
 */

func constructArr(a []int) []int {
	if len(a) == 0 {
		return []int{}
	}
	res := make([]int, len(a))
	m := 1
	res[0] = 1
	for i := 0; i < len(a)-1; i++ {
		m = m * a[i]
		res[i+1] = m
	}
	t := 1
	for i := len(a) - 2; i >= 0; i-- {
		t *= a[i+1]

		res[i] = res[i] * t
	}
	return res
}
