package offerII

import "math"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/11 16:36
 */

//a = 15, b = 2
func divide(a int, b int) int {
	// 边界条件
	if a == math.MinInt32 && b == -1 {
		return math.MaxInt32
	}
	if a == 0 {
		return 0
	}
	if b == 1 {
		return a
	}
	if b == a {
		return 1
	}
	flag := true
	if a < 0 && b > 0 || a > 0 && b < 0 {
		flag = false
	}
	var res = 0
	// 防止溢出
	if a > 0 {
		a = -a
	}
	if b > 0 {
		b = -b
	}
	// 开始累加
	for a <= b {
		count := 1
		temp := b
		// for
		for temp >= a-temp {
			count++
			temp += temp
		}
		res = res + count
		a = a - temp
	}
	if flag {
		return res
	}
	return -res
}
