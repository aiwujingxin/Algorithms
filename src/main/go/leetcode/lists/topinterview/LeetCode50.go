package topinterview

func myPow(x float64, n int) float64 {
	if x == 0 {
		return x
	}
	//fix n == 0
	if n == 0 {
		return 1
	}
	//fix n < 0
	if n < 0 {
		n = -n
		x = 1 / x
	}
	if n == 1 {
		return x
	}
	if n%2 == 0 {
		return myPow(x*x, n/2)
	}
	return x * myPow(x*x, n/2)
}
