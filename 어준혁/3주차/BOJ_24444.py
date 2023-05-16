from collections import deque
import sys

input = sys.stdin.readline


# # n: 정점의 수
# # m: 간선의 수
# # r: 시작 정점
n, m, r = map(int, input().split())

# 그래프는 1부터 시작
graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)
count = 1

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def bfs(v):
    global count

    q = deque([r])
    visited[r] = 1
    while q:
        v = q.popleft()
        graph[v].sort()
        for g in graph[v]:
            if visited[g] == 0:
                count += 1
                visited[g] = count
                q.append(g)


bfs(r)

for v in visited[1:]:
    print(v)

# 3 n logN 1 1 1 1 m