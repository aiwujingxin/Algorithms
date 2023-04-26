package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/25 13:34
 */

func canPartition(nums []int) bool {
	if len(nums) == 0 {
		return false
	}
	sum := 0
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
	}
	if sum%2 == 1 {
		return false
	}
	target := sum / 2
	dp := make([]bool, target+1)

	//背包容量为0 不论有多少商品，只要什么商品都不选，就能使选中的物品总量为0
	dp[0] = true
	for j := 0; j < len(nums); j++ {
		for i := target; i >= 0; i-- { // target为什么要在里层？
			if nums[j] > i {
				continue
			}
			dp[i] = dp[i] || dp[i-nums[j]]
		}
	}
	return dp[target]
}
