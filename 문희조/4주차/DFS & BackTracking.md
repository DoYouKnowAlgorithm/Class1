# [2주차] 재귀 & 그리디 알고리즘 정리
***
## 🎯 목표
* 재귀 알고리즘의 구조를 이해한다.
* 그리디 알고리즘을 이해하고 자주 나오는 유형을 익힌다. 
---
## 🔄️ 재귀 알고리즘
- 자기 자신을 다시 호출하는 구조를 가진 알고리즘
- 보통 더 작은 구조를 다시 호출해서 해결한다. 이는 **분할-정보 알고리즘**과 유사하다.
```java
 public void recursion(int n) {
    if (n == MIN_SIZE) {
        // 가장 작은 단위의 일을 한다.
    }
    // 가장 작은 단위가 될 때까지 쪼갠다.
    return recursion(n - 1);
}
```
### ✌ 특징
- 코드가 이뻐보일 순 있다. 하지만 ***스택 오버플로우***가 발생할 수 있고 정확한 호출 회수를 예측하기 어렵다.
- 따라서, 재귀로 풀 수 있는 문제는 **다른 방법으로 먼저 접근해본다**.
- 그래도 재귀로 풀겠다면, **가장 작은 단위의 일**에 대해 생각해본다.
- **어떤 규칙을 가지고 가장 작은 단위**로 쪼갤지 생각해본다. 
---
## 👻 탐욕법 (Greedy Algorithm)
- 주어진 순간에 가장 최선의 경우를 찾는 알고리즘
- 다른 알고리즘과 자주 같이 결합해서 등장한다.

### ✌ 특징
- **최선의 경우**라는 키워드 덕분에 자주 등장하는 알고리즘
- 당장의 최선의 경우를 기준으로 답을 찾아가기 때문에 전체의 경우에서 최적의 답을 찾을 순 없다.
- 최선의 경우를 잘 생각하는 것이 문제 해결의 키워드이다.

### 😎 자주 등장하는 유형
#### 1️⃣ 활동 선택 문제 (Activity Selection Problem)
- 강의실 배정, 박람회 돌기와 같은 문제이다.
- 2가지 유형이 존재한다. **많은 활동을 선택하기** 혹은 **효율적으로 공간을 활용하기** 이다.
- 이 문제에서 선택해야할 최선의 경우는 ***가장 빨리 끝나는 활동***이다.
#### 2️⃣ 배낭 채우기 (Knapsack Algorithm)
- 무게 W만큼 채울 수 있는 배낭에 최대한 많이, 최대한 가치가 높게 물건을 담아내는 알고리즘이다.
- 주어진 물건을 나눌 수 있는 경우(Fraction Knapsack)와 나눌 수 없는 경우(0-1 Knapsack)으로 나뉜다.
- 난이도가 보통 높은 편인데, **DP를 같이 적용해야하기 때문**이다.
```java
// 0-1 Knapsack
public int knapsack(int[] weights, int[] values, int maxWeight) {
    int n = weights.length;
    int[][] dp = new int[n + 1][maxWeight + 1];

    for (int i = 1 ; i <= n ; i++) {
        for (int w = 1 ; w <= maxWeight ; w++){
            dp[i][w] = dp[i-1][w];
            if (w - weights[i - 1] >= 0) {
                dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
            }
        }
    }

    return dp[n][maxWeight];
}
```

```java
// Fraction Knapsack
public int knapsack(int[] weights, int[] values, int maxWeight) {
    int n = weights.length;
    int[] dp = new int[maxWeight + 1];
    
    for (int w = 1; w <= maxWeight; w++) {
        for (int i = 0; i < n; i++) {
            if (weights[i] <= w) {
               dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }
    }
    
    return dp[maxWeight];
}
```
