package topinterview

import "math"

func reverse(x int) int {
	res := 0
	var flag bool
	if x < 0 {
		flag = true
		x = -1 * x
	}
	for x > 0 {
		res = res*10 + x%10
		x = x / 10
	}
	if res > math.MaxInt32 || res < math.MinInt32 {
		return 0
	}
	if flag {
		return -1 * res
	}
	return res
}
