package hot100

import "container/list"

//https://leetcode.com/problems/course-schedule/solutions/1149445/golang-beats-98/
func canFinish(numCourses int, prerequisites [][]int) bool {
	if len(prerequisites) == 0 {
		return true
	}
	adjList, inDegreeArr := getAdjListAndInDegreeArr(numCourses, prerequisites)
	var queue []int
	for node, inDegree := range inDegreeArr {
		if inDegree == 0 {
			queue = append(queue, node)
		}
	}
	if len(queue) == 0 {
		return false
	}
	for len(queue) > 0 {
		peek := queue[0]
		queue = queue[1:]
		list := adjList[peek]
		for _, neighbor := range list {
			inDegreeArr[neighbor] -= 1
			if inDegreeArr[neighbor] == 0 {
				queue = append(queue, neighbor)
			}
		}
	}
	for _, inDegree := range inDegreeArr {
		if inDegree != 0 {
			return false
		}
	}
	return true
}

func getAdjListAndInDegreeArr(numCourses int, prerequisites [][]int) ([][]int, []int) {
	adjList := make([][]int, numCourses)
	inDegreeArr := make([]int, numCourses)
	for i := 0; i < numCourses; i++ {
		adjList[i] = []int{}
	}
	for _, p := range prerequisites {
		src := p[1]
		dst := p[0]
		adjList[src] = append(adjList[src], dst)
		inDegreeArr[dst] += 1
	}
	return adjList, inDegreeArr
}

//https://leetcode.com/problems/course-schedule/solutions/1338075/golang-solution-using-topological-sort/
func canFinish_V2(numCourses int, prerequisites [][]int) bool {
	degree := make([]int, numCourses)
	adList := map[int][]int{}
	q := list.New()
	for _, node := range prerequisites {
		adList[node[1]] = append(adList[node[1]], node[0])
		degree[node[0]]++
	}
	for i := 0; i < numCourses; i++ {
		if degree[i] == 0 {
			q.PushBack(i)
		}
	}
	for q.Len() > 0 {
		f := q.Front().Value.(int)
		q.Remove(q.Front())
		numCourses--
		for _, s := range adList[f] {
			degree[s]--
			if degree[s] == 0 {
				q.PushBack(s)
			}
		}
	}
	return numCourses == 0
}
