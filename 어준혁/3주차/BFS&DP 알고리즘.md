# [3주차] BFS & DP 알고리즘

---

## ✅ BFS 알고리즘

- 가까운 노드부터 탐색하는 알고리즘(너비 우선 탐색)
- BFS 구현에서는 선입선출 방식인 큐 자료구조를 이용하는 것이 정석

```python
# BFS 메서드 정의
# deque 라이브러리 불러오기
from collections import deque

# BFS 메서드 정의
def bfs (graph, node, visited):
    # 큐 구현을 위한 deque 라이브러리 활용
    queue = deque([node])
    # 현재 노드를 방문 처리
    visited[node] = True

    # 큐가 완전히 빌 때까지 반복
    while queue:
        # 큐에 삽입된 순서대로 노드 하나 꺼내기
        v = queue.popleft()
        # 탐색 순서 출력
        print(v, end = ' ')
        # 현재 처리 중인 노드에서 방문하지 않은 인접 노드를 모두 큐에 삽입
        for i in graph[v]:
            if not (visited[i]):
                queue.append(i)
                visited[i] = True

graph = [
    [],
    [2, 3],
    [1, 8],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7, 8],
    [6, 8],
    [2, 6, 7]
]

# 노드별로 방문 정보를 리스트로 표현
visited = [False] * 9

# 정의한 BFS 메서드 호출(노드 1을 탐색 시작 노드로 설정)
bfs(graph, 1, visited)
```

### 🔖 특징

- 재귀적으로 동작하지 않는다.
- 그래프 탐색의 경우 무한루프에 빠질 위험이 있기 때문에 어떤 노드를 방문했었는지 여부를 반드시 검사해야 한다.

### ✔️ 동작 방식

1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리를 한다.
3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.

---

## ✅ DP 알고리즘

- 문제를 풀 때 하나의 문제를 여러 하위 문제로 나누어 풀고, 그것들을 결합해서 최종 목적에 도달하는 방식의 알고리즘
- DP를 사용하는 이유는 일반적인 재귀를 단순히 사용 시 동일한 작은 문제들이 여러 번 반복 되어 비효율적인 계산이 될 수 있기 때문(ex: 피보나치 수열)
  ![이미지](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Ft3PF0%2FbtqSgLZbXTp%2FdRqSxgLwa4padvt3qtAqNk%2Fimg.png)

### 🔥 사용 조건

- 동일한 작은 문제들이 반복하여 나타나는 경우
- 부분 문제의 최적 결과 값을 사용해 전체 문제의 최적 결과를 낼 수 있는 경우
