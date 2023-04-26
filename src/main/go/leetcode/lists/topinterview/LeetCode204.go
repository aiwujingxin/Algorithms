package topinterview

func countPrimes(n int) int {
	cnt := 0
	notPrime := make([]bool, n)
	for i := 2; i < n; i++ {
		if !notPrime[i] {
			cnt++
			for j := 2; i*j < n; j++ {
				notPrime[i*j] = true
			}
		}
	}
	return cnt
}
