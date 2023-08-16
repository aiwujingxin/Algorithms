package classic

import "math"

/**
 * @Author: jingxinwu
 * @Date: 2023/2/27 21:32
 */

func missingTwo(nums []int) []int {
	maxValue := len(nums) + 2
	remSquare := squareSumToN(maxValue, 2)
	remOne := maxValue * (maxValue + 1) / 2

	for i := 0; i < len(nums); i++ {
		remSquare -= nums[i] * nums[i]
		remOne -= nums[i]
	}

	return solveEquation(remOne, remSquare)
}
func squareSumToN(n int, power int) int {
	var sum float64
	for i := 1; i <= n; i++ {
		sum += math.Pow(float64(i), float64(power))
	}
	return int(sum)
}

func solveEquation(r1, r2 int) []int {
	a := 2
	b := -2 * r1
	c := r1*r1 - r2

	part1 := -1 * b
	part2 := math.Sqrt(float64(b*b - 4*a*c))
	part3 := 2 * a

	solutionX := (part1 + int(part2)) / part3
	solutionY := r1 - solutionX

	return []int{solutionX, solutionY}
}
