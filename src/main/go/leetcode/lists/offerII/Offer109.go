package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/29 20:11
 */

func openLock(deadends []string, target string) int {
	if target == "0000" {
		return 0
	}

	dead := make(map[string]bool)
	visited := make(map[string]bool)
	for _, deadend := range deadends {
		dead[deadend] = true
	}
	if dead[target] || dead["0000"] {
		return -1
	}
	q := make([]string, 0)
	q = append(q, "0000")
	level := 0
	getNext := func(cur string) []string {
		list := make([]string, 0)
		bytes := []byte(cur)
		for i := range bytes {
			t := bytes[i]
			if t == '0' {
				bytes[i] = '9'
				list = append(list, string(append([]byte(nil), bytes...)))
				bytes[i] = '1'
				list = append(list, string(append([]byte(nil), bytes...)))
			} else if t == '9' {
				bytes[i] = '8'
				list = append(list, string(append([]byte(nil), bytes...)))
				bytes[i] = '0'
				list = append(list, string(append([]byte(nil), bytes...)))
			} else {
				bytes[i] = t + 1
				list = append(list, string(append([]byte(nil), bytes...)))
				bytes[i] = t - 1
				list = append(list, string(append([]byte(nil), bytes...)))
			}
			bytes[i] = t
		}
		return list
	}
	for len(q) > 0 {
		size := len(q)
		level++
		for size > 0 {
			cur := q[0]
			q = q[1:]
			nexts := getNext(cur)
			for i := 0; i < len(nexts); i++ {
				if dead[nexts[i]] {
					continue
				}
				if nexts[i] == target {
					return level
				}
				if visited[nexts[i]] {
					continue
				}
				q = append(q, nexts[i])
				visited[nexts[i]] = true
			}
			size--
		}
	}
	return -1
}
