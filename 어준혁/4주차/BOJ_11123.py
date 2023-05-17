import sys
sys.setrecursionlimit(10000)

t = int(input())

def dfs(x,y):
    visited[x][y] = True
    for dx, dy in (-1, 0), (1,0), (0, -1), (0, 1):
        nx, ny = x + dx, y + dy
        if nx < 0 or nx >= h or ny < 0 or ny >= w:
            continue
        if not visited[nx][ny] and graph[nx][ny] == '#':
            dfs(nx, ny)

for _ in range(t):
    h, w = map(int, input().split())
    count = 0
    graph = [list(input().strip()) for _ in range(h)]
    visited = [[False] * w for _ in range(h)]
    for i in range(h):
        for j in range(w):
            if not visited[i][j] and graph[i][j] == '#':
                dfs(i, j)
                count += 1
    print(count)