package classic

import (
	"strconv"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 18:21
 * @description 区间DP
	https://www.youtube.com/watch?v=Xfk2lEByP9M 20min
	https://leetcode.cn/problems/boolean-evaluation-lcci/solution/java-fen-zhi-ji-yi-hua-di-gui-lei-si-yu-241-ti-241/
*/

func countEval(s string, result int) int {
	memo := make(map[string][2]int)
	var dfs func(s string) [2]int
	dfs = func(s string) [2]int {
		if v, ok := memo[s]; ok {
			return v
		}
		if len(s) == 1 {
			curRes := [2]int{}
			if s[0] == '0' {
				curRes[0]++
			} else {
				curRes[1]++
			}
			memo[s] = curRes
			return curRes
		}
		curRes := [2]int{}
		for i := 0; i < len(s); i++ {
			ch := s[i]
			if ch >= '0' && ch <= '9' {
				continue
			}
			left := dfs(s[0:i])
			right := dfs(s[i+1:])

			for l := 0; l <= 1; l++ {
				for r := 0; r <= 1; r++ {
					ret := 0
					if ch == '|' {
						ret = l | r
					} else if ch == '^' {
						ret = l ^ r
					} else {
						ret = l & r
					}
					if ret == 0 {
						curRes[0] += left[l] * right[r]
					} else {
						curRes[1] += left[l] * right[r]
					}
				}
			}
		}
		memo[s] = curRes
		return curRes
	}
	ans := dfs(s)
	if result == 0 {
		return ans[0]
	}
	return ans[1]
}

func countEval_ERROR(s string, result int) int {
	if len(s) == 0 {
		return 0
	}
	res := 0
	var cal = func(s string) int {
		one := int(s[0] - '0')
		two := int(s[2] - '0')
		switch s[1] {
		case '^':
			return one ^ two
		case '&':
			return one & two
		case '|':
			return one | two
		}
		return 0
	}
	var dfs func(s string)
	dfs = func(s string) {
		if len(s) < 3 {
			return
		}
		if len(s) == 3 && cal(s) == result {
			res++
			return
		}
		// 发现重叠子问题， 但是并没有解决
		for i := 0; i < len(s)-2; i += 2 {
			temp := s
			w := s[:i] + strconv.Itoa(cal(s[i:i+3])) + s[i+3:]
			dfs(w)
			s = temp
		}
	}
	dfs(s)
	return res
}
