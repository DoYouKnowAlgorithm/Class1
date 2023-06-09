# [3주차] DP & BFS 알고리즘 정리

***

## 🎯 목표

* 목표

---

## 🔄️ DP, BFS 알고리즘

- 알고리즘

---

### 🎯 [BOJ_14916] 거스름돈

---

#### 👉 접근법

- DP 의 가장 기본적인 문제라 생각이 들어 점화식을 바로 찾으려 했다.
- 직접 값을 계산해가며 규칙을 발견했고 바로 코드로 옮겨 적어 구현했다 (아래 이미지 참조)

#### ⏳ 시간복잡도

- 0부터 N까지 반복문을 1번 돌기 때문에 O(n) 이라 생각한다.


![거스름돈](https://user-images.githubusercontent.com/110602069/236113635-6d934d40-c88a-46e3-a92e-9317f14421e3.jpeg)



#

### 🎯 [BOJ_24444] 알고리즘 수업 - 너비 우선 탐색 1

---

#### 👉 접근법

- 이 문제는 예전에 풀었던 문제라 쉽게 답이 떠올랐다. 하지만 이번에 접근법은 그때와 다르다.
- 우선 시간 복잡도를 조금이나마 접근할 수 있었기 때문이다.
- 로직은 우선순위큐에 넣으면서 자동으로 정렬을 맡겼고 (시간복잡도도 유리하다)
- 방문하는 순서대로 정답 배열에 추가하면서 정답을 채워나갔다.
- bfs의 가장 기본적인 로직이라 딱히 추가 설명이 어렵다.. (그림으로 대체한다)

#### ⏳ 시간복잡도

- 제 로직의 시간 복잡도는.....
- 우선순위 큐를 new 해주는 for문에서 O(nodeSize)
- 간선의 수만큼 입력받는 for문에서 O(edgeSize) + 우선순위 큐 정렬시간 O(edgeSize log edgeSize)
- BFS 를 돌면서 O(log edgeSize)
- 마지막 정답을 만드는 for문에서 O(nodeSize)
- O(nodeSize) + O(edgeSize) + O(edgeSize log edgeSize) + O(log edgeSize) + O(nodeSize)..?
- 시간복잡도는 O(2nodeSize+edgeSize + edgeSize log edgeSize)


![24444](https://user-images.githubusercontent.com/110602069/236210565-3fbf094f-2ff4-49e6-a9b6-18ce1c361e5a.jpeg)



### 🎯 [BOJ_14494] 다이나믹이 뭐예요?

---

#### 👉 접근법

- DP 라 당연히 점화식을 찾는데 집중했으며
- 주어진 경우의 수가 ➡️ ⬇️ ↘️ 로 조금은 헷갈렸으나 결국엔 단조로운 점화식이라
- 쉽게 찾을 수 있었다
- [거스름돈] 문제도 그렇고 디피는 항상 메모를 하면서 찾으면 조금은 수월하게 찾는 것 같다

#### ⏳ 시간복잡도

- n * m 만큼 돌기 때문에 O(n*m) 의 복잡도라 생각한다.


![14494](https://user-images.githubusercontent.com/110602069/236133375-27dd6793-3ac8-415a-a0e8-888ebe140e71.jpeg)



#

### 🎯 [BOJ_12869] 뮤탈리스크

---

#### 👉 접근법

- 맨 처음에는 점화식을 찾으려고 했지만 실패했다...
- 블로그를 보니 분할정복마냥 BFS 를 돌리길래 최대한 이해한 범위내에서 BFS 탐색을 돌렸다
- 거의 완전탐색 수준으로 돌리는 것 같은 느낌인데도 불구하고 시간초과는 나지 않았다
- 뮤탈 데미지가 9, 3, 1 로 들어가기 때문에 총 6가지의 경우의 수로 찾아나가는 방식이 이해가 됐고
- 최소 공격 횟수를 계속 업데이트 해줌과 동시에 이미 방문한 곳은 방문하지 않도록 로직을 짰다
- 정렬을 하기 전에는 틀렸다고 뜨는데 왜 정렬이 필요한지 이해가 가지 않는다
- (아래 사진은 점화식을 찾았던 시도일뿐 성공하지 못했다)

#### ⏳ 시간복잡도

- O(n^2) 무지성 완전 탐색같아서요..


![12869](https://github.com/DoYouKnowAlgorithm/Class1/assets/110602069/d59581cd-ae24-4168-8de2-d982f7a15e87)
