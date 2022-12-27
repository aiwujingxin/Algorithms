package topinterview

//https://leetcode.com/problems/divide-two-integers/solutions/1194818/succinct-go-solution-faster-than-100/
func divide(dividend int, divisor int) int {
	if dividend == (-2<<30) && divisor == -1 {
		return (2 << 30) - 1
	}

	dividendAbs := Abs(dividend)
	divisorAbs := Abs(divisor)
	res := 0

	for dividendAbs-divisorAbs >= 0 {
		exponent := 0 //指数
		for dividendAbs >= divisorAbs<<exponent {
			exponent++
		}
		res += 1 << (exponent - 1)
		dividendAbs = dividendAbs - divisorAbs<<(exponent-1)
	}
	if (divisor > 0) == (dividend >= 0) {
		return res
	}
	return -res
}
