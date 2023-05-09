# BFS & DP 알고리즘 정리
---
## 🔍 너비 우선 탐색(Breadth First Search, BFS) 알고리즘
- 시작 정점으로부터 가장 가까운 정점을 먼저 방문하고, 멀리 떨어져 있는 정점을 나중에 방문하는 알고리즘
- BFS는 두 노드 사이의 최단 경로를 찾고 싶을 때 사용
### ✏️ [Boj24444] 너비 우선 탐색 1
<img width=400 height=350 src="https://github.com/DoYouKnowAlgorithm/Class1/assets/110653660/262fb03e-4066-442b-825c-da3d441cd142">
<ol>
  <li>각 정점의 탐색 순서를 담을 result 배열을 생성한다.
  <li>Queue에 시작 정점을 넣고, visited 배열에서 시작 정점을 방문 처리한다.
  <li>result 배열에 시작 정점 위치의 값을 1 증가시킨 count, 즉 1로 초기화한다.
</ol>
<p>
탐색할 모든 준비가 끝나면 반복문을 통해서 다음의 과정을 거친다.
</p>

<img width=400 height=350 src="https://github.com/DoYouKnowAlgorithm/Class1/assets/110653660/7459b274-37b2-4498-9d7a-381cbdbec525">
<ol>
  <li>큐에 요소가 들어 있다면, 해당 요소를 꺼내 인접한 정점을 찾는다.
  <li>찾은 정점이 방문 처리가 되지 않았다면, 큐에 해당 정점을 넣고 방문 처리한다.
  <li>result 배열에 해당 정점 위치의 값을 1 증가시킨 count로 초기화한다.
</ol>
<p>
지금까지의 작업을 큐가 빌 때까지 반복하면 result 배열은 {0, 1, 2, 4, 3, 0}이 되고, 인덱스가 1인 위치의 값부터 출력한다.
</p>

---
## 🔍 동적 계획법(Dynamic Programming, DP)
- 하나의 큰 문제를 여러 개의 작은 문제로 나누어서 그 결과를 저장하고, 다시 큰 문제를 해결하기 위해 사용하는 방식
- 일반적인 재귀를 사용했을 때 나타나는 비효율적인 연산을 생략하기 위해서 사용
### ✏️ [Boj14916] 거스름돈
<img  src="https://github.com/DoYouKnowAlgorithm/Class1/assets/110653660/04607604-6e15-44c5-af05-bcc735b7ad04">

