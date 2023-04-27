import sys
input = sys.stdin.readline

def init(n):
    global maxInput, taskTable
    
    for _ in range(n):
        num = int(input())
        taskTable += [num]
        maxInput = max(maxInput, num)

def countPassedByGivenTime(givenTime):
    passed = 0
    
    for task in taskTable:
        passed += givenTime // task
    
    return passed

def calcMinTime(people):
    minTime = 0
    maxTime = maxInput * people
    
    while minTime <= maxTime:
        middleTime = (minTime + maxTime) // 2
        passed = countPassedByGivenTime(middleTime)
            
        if passed < people:
            minTime = middleTime + 1
        else :
            maxTime = middleTime - 1
            
    return minTime

n, m = map(int, input().split())

maxInput, taskTable = 0, []
init(n)

minTime = calcMinTime(m)
print(minTime)