import sys
input = sys.stdin.readline
n = int(input())

graph = [list(map(str, input().split())) for _ in range(n)]
visited = [[False for _ in range(n)]for _ in range(n)]
min_value = sys.maxsize
max_value = -sys.maxsize

def dfs(x, y, v):
    global min_value, max_value
    if x == n - 1 and y == n - 1:
        min_value = min(min_value, v)
        max_value = max(max_value, v)
    for dx, dy in (1, 0), (0, 1):
        nx, ny = x + dx, y + dy
        if nx >= n or ny >= n:
            continue
        if graph[x][y] == '+':
            dfs(nx, ny, v + graph[nx][ny])
        elif graph[x][y] == '-':
            dfs(nx, ny, v - graph[nx][ny])
        elif graph[x][y] == '*':
            dfs(nx, ny, v * graph[nx][ny])
        else: 
            dfs(nx, ny, v)

for i in range(n):
    for j in range(n):
            if(i+j) % 2 == 0:
                graph[i][j] = int(graph[i][j])

dfs(0, 0, graph[0][0])
print(max_value,min_value)
