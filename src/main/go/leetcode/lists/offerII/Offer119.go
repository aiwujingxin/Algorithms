package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/30 17:42
 */

func longestConsecutive(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	mp := make(map[int]bool)
	for i := 0; i < len(nums); i++ {
		mp[nums[i]] = true
	}
	res := 0
	for value := range mp {
		if mp[value-1] {
			continue
		}
		t := 1
		v := value + 1
		for mp[v] {
			v++
			t++
		}
		res = Max(res, t)
	}
	return res
}
