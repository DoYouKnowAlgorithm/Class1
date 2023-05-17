# DFS & 백트래킹 알고리즘 정리
---
## 🔍 깊이 우선 탐색(Depth First Search, DFS) 알고리즘
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
## 🔍 백트래킹 알고리즘

모든 경우의 수를 탐색하는 DFS와 달리 백트래킹은 불필요한 경로를 탐색하지 않는다는 차이가 있다.
