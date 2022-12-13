package hot100

func countBits(n int) []int {
	if n == 0 {
		return []int{0}
	}
	res := make([]int, n+1)
	res[0] = 0
	for i := 1; i <= n; i++ {
		num, cnt := i, 0
		for num > 0 {
			if num&1 == 1 {
				cnt++
			}
			num = num >> 1
		}
		res[i] = cnt
	}
	return res
}
