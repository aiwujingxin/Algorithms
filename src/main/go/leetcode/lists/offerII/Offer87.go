package offerII

import (
	"strconv"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/28 19:07
 */

func restoreIpAddresses(s string) []string {
	if len(s) == 0 || len(s) > 15 {
		return []string{}
	}
	res := make([]string, 0)
	var dfs func(start int, temp []string)
	dfs = func(start int, temp []string) {
		if start == len(s) && len(temp) == 4 {
			ip := ""
			for i := 0; i < len(temp); i++ {
				ip += temp[i]
				if i != len(temp)-1 {
					ip += "."
				}
			}
			res = append(res, ip)
			return
		}
		for end := start + 1; end <= len(s); end++ {
			if len(s[start:end]) > 1 && s[start] == '0' {
				continue
			}
			t, _ := strconv.Atoi(s[start:end])
			if t >= 0 && t <= 255 {
				temp = append(temp, s[start:end])
				dfs(end, temp)
				temp = temp[:len(temp)-1]
			} else {
				return
			}
		}
	}
	dfs(0, []string{})
	return res
}
