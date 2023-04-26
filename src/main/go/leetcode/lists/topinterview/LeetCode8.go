package topinterview

import (
	"math"
	"strings"
)

func myAtoi(s string) int {
	if len(s) == 0 {
		return 0
	}
	s = strings.TrimSpace(s)
	if len(s) == 0 {
		return 0
	}
	index, sign := 0, 1
	if s[index] == '+' {
		sign = 1
	} else if s[index] == '-' {
		sign = -1
	}
	index++
	res := 0
	for index < len(s) {
		num := int(s[index] - '0')
		if num < 0 || num > 9 {
			break
		}
		res = res*10 + num
		if res > math.MaxInt32 {
			if sign == 1 {
				return math.MaxInt32
			} else {
				return math.MinInt32
			}
		}
		index++
	}
	return sign * res
}
