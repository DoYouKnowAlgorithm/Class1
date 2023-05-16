import sys
input = sys.stdin.readline
n = int(input())

money_arr = [list(map(int, input().split())) for _ in range(n)]
visited=[False for _ in range(n)]
min_money = sys.maxsize

def back(start, cur, money):
    global money_arr, visited, min_money
    if start == cur and visited.count(False) == 0:
        min_money = min(min_money, money)

    for i in range(n):
        if not visited[i] and not money_arr[cur][i] == 0:
            visited[i] = True
            back(start, i, money+money_arr[cur][i])
            visited[i] = False

back(0, 0 ,0)
print(min_money)