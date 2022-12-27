package topinterview

func isHappy(n int) bool {
	m := map[int]bool{}
	step := func(n int) int {
		sum := 0
		for n > 0 {
			sum += (n % 10) * (n % 10)
			n = n / 10
		}
		return sum
	}
	for ; n != 1 && !m[n]; n, m[n] = step(n), true {
	}
	return n == 1
}
