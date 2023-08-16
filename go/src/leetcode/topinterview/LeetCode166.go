package topinterview

import (
	"strconv"
)

// 用程序模拟算术运算
func fractionToDecimal(numerator int, denominator int) string {
	var res string
	var sign string
	if (numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0) {
		sign = "-"
	}
	//fix
	numerator = Abs(numerator)
	denominator = Abs(denominator)
	res = res + sign
	num := numerator % denominator
	res = res + strconv.Itoa(numerator/denominator)
	if num == 0 {
		return res
	}
	mp := make(map[int]int)
	res = res + "."
	mp[num] = len(res)

	for num != 0 {
		num = num * 10
		res = res + strconv.Itoa(num/denominator)
		num = num % denominator
		if index, ok := mp[num]; ok {
			res = res[0:index] + "(" + res[index:] + ")"
			break
		} else {
			mp[num] = len(res)
		}
	}
	return res
}
