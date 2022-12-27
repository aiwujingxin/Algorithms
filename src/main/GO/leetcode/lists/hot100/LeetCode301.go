package hot100

func removeInvalidParentheses(s string) []string {
	if len(s) == 0 {
		return []string{}
	}
	q := make([]string, 0)
	visited := make(map[string]bool)
	q = append(q, s)
	visited[s] = true
	var found bool
	res := make([]string, 0)
	for len(q) > 0 {
		cur := q[0]
		q = q[1:]

		if checkParenthes(cur) {
			// found an answer, add to the result
			res = append(res, cur)
			found = true
		}
		if found {
			continue
		}
		// generate all possible states
		// 根据当前值进行下一跳
		for i := 0; i < len(cur); i++ {
			// we only try to remove left or right paren
			if cur[i] != '(' && cur[i] != ')' {
				continue
			}
			t := cur[:i] + cur[i+1:]
			if !visited[t] {
				q = append(q, t)
				visited[t] = true
			}
		}
	}
	if len(res) == 0 {
		return []string{""}
	}
	return res
}

func checkParenthes(str string) bool {
	cnt := 0
	for _, ch := range str {
		if ch == '(' {
			cnt++
		} else if ch == ')' {
			cnt--
			if cnt < 0 {
				return false
			}
		}
	}
	return cnt == 0
}
