package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/12 14:13
 */

func pairSums(nums []int, target int) [][]int {
	if len(nums) == 0 {
		return [][]int{}
	}
	mp := make(map[int][]int)
	res := make([][]int, 0)
	for i := 0; i < len(nums); i++ {
		if mp[nums[i]] == nil {
			mp[nums[i]] = []int{i}
		} else {
			mp[nums[i]] = append(mp[nums[i]], i)
		}
	}

	for _, num := range nums {
		numList := mp[num]
		if len(numList) == 0 {
			continue
		}
		other := target - num
		if list, ok := mp[other]; ok && len(list) > 0 {
			if num != other {
				mp[other] = list[1:]
				mp[num] = numList[1:]
				res = append(res, []int{num, other})
			} else {
				if len(list) == 1 {
					continue
				}
				res = append(res, []int{num, other})
				mp[num] = numList[2:]
			}
		}
	}
	return res
}

//=== Fast
func pairSumsV2(nums []int, target int) [][]int {
	numsMap := map[int]int{}
	var res [][]int
	for _, num1 := range nums {
		numsMap[num1]++
		num2 := target - num1
		if c := numsMap[num2]; (c > 0 && num1 != num2) || (num1 == num2 && c > 1) {
			numsMap[num1]--
			numsMap[num2]--
			res = append(res, []int{num2, num1})
		}
	}

	return res
}
