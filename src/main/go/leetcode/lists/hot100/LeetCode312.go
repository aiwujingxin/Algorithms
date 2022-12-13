package hot100

import "math"

func maxCoins(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	arr := make([]int, len(nums)+2)
	arr[0] = 1
	arr[len(arr)-1] = 1
	for i := 1; i <= len(nums); i++ {
		arr[i] = nums[i-1]
	}
	dp := make([][]int, len(arr))
	for i := 0; i < len(arr); i++ {
		dp[i] = make([]int, len(arr))
	}
	for i := len(nums); i >= 1; i-- {
		for j := 1; j <= len(nums); j++ {
			if i > j {
				continue
			}
			max := math.MinInt32
			for k := i; k <= j; k++ {
				coins := arr[i-1]*arr[k]*arr[j+1] + dp[i][k-1] + dp[k+1][j]
				max = Max(coins, max)
			}
			dp[i][j] = max
		}
	}
	return dp[1][len(nums)]
}

func maxCoinsDfs(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	N := len(nums)
	arr := make([]int, N+2)
	arr[0] = 1
	arr[len(arr)-1] = 1
	for i := 1; i <= N; i++ {
		arr[i] = nums[i-1]
	}
	dp := make([][]int, N+1)
	for i := 0; i < N+1; i++ {
		dp[i] = make([]int, N+1)
	}
	for i := 0; i < N+1; i++ {
		for j := 0; j < N+1; j++ {
			dp[i][j] = -1
		}
	}
	var dfs func(nums []int, i int, j int) int
	dfs = func(nums []int, i int, j int) int {
		if j < i {
			return 0
		}
		if dp[i][j] != -1 {
			return dp[i][j]
		}
		max := math.MinInt32
		for k := i; k <= j; k++ {
			temp := arr[k]*arr[i-1]*arr[j+1] +
				dfs(nums, i, k-1) + dfs(nums, k+1, j)
			max = Max(max, temp)
		}
		dp[i][j] = max
		return dp[i][j]
	}
	return dfs(nums, 1, N)
}
