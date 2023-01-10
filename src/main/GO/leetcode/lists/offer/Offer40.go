package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 23:55
 */

/**
[4,5,1,6,2,7,3,8]
4

[3,2,1]
2

[0,1,2,1]
1

case
[0,0,2,3,2,1,1,2,0,4]
10
*/
func getLeastNumbers(arr []int, k int) []int {
	if len(arr) < k {
		return []int{}
	}
	var dfs func(arr []int, i, j int) []int
	dfs = func(arr []int, i, j int) []int {
		if i <= j {
			index := part(arr, i, j)
			if index == k {
				return arr[:index]
			} else if index < k {
				return dfs(arr, index+1, j)
			} else {
				return dfs(arr, i, index-1)
			}
		}
		return arr[:i]
	}
	return dfs(arr, 0, len(arr)-1)
}

func part(nums []int, i int, j int) int {
	pi := nums[i]
	for i < j {
		for i < j && nums[j] >= pi {
			j--
		}
		nums[i] = nums[j]
		for i < j && nums[i] <= pi {
			i++
		}
		nums[j] = nums[i]
	}
	nums[i] = pi
	return i
}
