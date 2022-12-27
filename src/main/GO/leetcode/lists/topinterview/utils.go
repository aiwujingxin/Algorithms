package topinterview

import "strconv"

func Max(i, j int) int {
	if i > j {
		return i
	}
	return j
}

func Min(i, j int) int {
	if i < j {
		return i
	}
	return j
}
func Str2Int(s string) int {
	res, _ := strconv.Atoi(s)
	return res
}
func IsNumber(ch byte) bool {
	return ch >= '0' && ch <= '9'
}

func Reverse(s []int, start, end int) []int {
	for i, j := start, end; i < j; i, j = i+1, j-1 {
		s[i], s[j] = s[j], s[i]
	}
	return s
}

func Abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
