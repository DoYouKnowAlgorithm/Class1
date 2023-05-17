# DFS & 백트래킹 알고리즘 정리
---
## 🔍 깊이 우선 탐색(Depth First Search, DFS) 알고리즘
- 모든 경우의 수를 깊이 우선으로 탐색하는 알고리즘
- 특정 정점에서 시작하여 가까운 하나의 정점을 정해서 깊숙하게 탐색하고, 더 이상 방문할 정점이 없다면 다시 돌아가는 방식
- 모든 정점을 탐색하고 싶은 경우 사용
- 검색 속도는 BFS보다 느림
### 구현 방식
#### 1. 재귀를 사용하는 방식
- 재귀를 사용하면 DFS 알고리즘을 간단하고 직관적으로 구현 가능
- 시작 정점을 기준으로 인접한 정점 중 방문하지 않는 정점 하나를 선택하여 재귀적으로 탐색하는 방식
- 호출 스택을 사용하기 때문에 깊이가 깊어지면 스택 오버플로우가 발생할 수 있다.
#### 2. 스택을 사용하는 방식
- 스택을 사용하여 현재 정점과 인접한 정점 중 방문하지 않은 놈을 추적하면서 탐색하는 방식
- 구현 예제
```java
public static void dfs(int startVertex) {
        Stack stack = new Stack();
	visited[startVertex] = true;
        stack.push(startVertex);
        int count = 0;
	result[startVertex] = ++count;

        while (!stack.isEmpty()) {
            int v = (int) stack.peek();
            boolean hasNearVertex = false;
            for (int i = 0; i < adjList.get(v).size(); i++) {
                int nextV = adjList.get(v).get(i);
                if (!visited[nextV]) {
                    hasNearVertex = true;
		    visited[nextV] = true;
                    stack.push(nextV);
		    result[nextV] = ++count;
                }
            }

            if (!hasNearVertex) {
                stack.pop();
            }
        }
    }
```
---
## 🔍 백트래킹 알고리즘
- 주어진 제약 조건을 만족하는 모든 경우의 수를 탐색하는 알고리즘
- 탐색 과정에서 제약 조건을 확인하고, 조건을 만족하지 않으면 이전 단계로 돌아가서 다른 경우의 수를 탐색
- 불필요한 부분을 쳐낸다는 의미에서 가지치기라고도 불림
---
## ❓ DFS와 백트래킹의 차이
백트래킹은 언뜻 보면 DFS와 같아 보이지만, 모든 경우의 수를 탐색하는 DFS와 달리 불필요한 경로를 탐색하지 않는다.
