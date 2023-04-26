package classic

import (
	"strconv"
	"strings"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/9 17:04
 */

func trulyMostPopular(names []string, synonyms []string) []string {
	times := map[string]int{}
	parent := map[string]string{}
	for _, str := range names {
		name, time := getNameTime(str)
		times[name] = time
		parent[name] = name
	}
	for _, synonym := range synonyms {
		synonym = synonym[1 : len(synonym)-1]
		list := strings.Split(synonym, ",")
		parent[list[0]] = list[0]
		parent[list[1]] = list[1]
	}

	var find func(id string) string
	find = func(id string) string {
		if parent[id] != id {
			parent[id] = find(parent[id])
		}
		return parent[id]
	}

	for _, str := range synonyms {
		idx := strings.IndexByte(str, ',')
		name1, name2 := str[1:idx], str[idx+1:len(str)-1]
		p1, p2 := find(name1), find(name2)
		if p1 == p2 {
			continue
		}
		if p1 > p2 {
			p1, p2 = p2, p1
		}

		times[p1] += times[p2]
		parent[p2] = p1
		delete(times, p2)
	}

	res := make([]string, 0, len(times))
	for id, time := range times {
		res = append(res, id+"("+strconv.Itoa(time)+")")
	}

	return res
}

func getNameTime(str string) (name string, times int) {
	idx := strings.IndexByte(str, '(')
	name = str[:idx]
	times, _ = strconv.Atoi(str[idx+1 : len(str)-1])
	return
}
