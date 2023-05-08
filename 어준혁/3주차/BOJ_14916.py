import sys
input = sys.stdin.readline

def solution(money):
    count = 0
    
    while money > 0:
        if money % 5 == 0:
            count += money//5
            break
        else:
            money -= 2
            count += 1

    if money < 0:
        print(-1)
    else:
        print(count)

money = int(input())
solution(money)
