package topinterview

func trailingZeroes(n int) int {
	if n == 0 {
		return 0
	}
	// 以5的数量为准
	ans := 0
	for n != 0 {
		n /= 5
		ans += n
	}
	return ans
}
