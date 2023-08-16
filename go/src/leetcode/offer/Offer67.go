package offer

import (
	"math"
	"strings"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/9 21:47
 */

func strToInt(str string) int {
	if len(str) == 0 {
		return 0
	}
	str = strings.TrimSpace(str)
	if len(str) == 0 {
		return 0
	}
	flag := 1
	index := 0
	res := 0
	if str[index] == '-' {
		flag = -1
		index++
	} else if str[index] == '+' {
		flag = 1
		index++
	}
	if index == len(str) {
		return 0
	}
	if str[index] < '0' || str[index] > '9' {
		return 0
	}
	for index < len(str) && str[index] >= '0' && str[index] <= '9' {
		res = res*10 + int(str[index]-'0')
		index++
		if res > math.MaxInt32 {
			if flag == 1 {
				return math.MaxInt32
			} else {
				return math.MinInt32
			}
		}
	}
	return flag * res
}
