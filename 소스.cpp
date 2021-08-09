#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int N, K;
bool check[100001];

int bfs(int current) {
	queue<int> q;
	int time = 0;
	q.push(current);

	// 큐가 빌때까지 반복
	while (!q.empty()) {
		int size = q.size();

		for (int i = 0; i < size; i++) {
			current = q.front();
			q.pop();
			if (current == K) {
				return time;
			}
			
			// 뒤로 한칸
			if (current > 0 && check[current - 1] == 0) {
				q.push(current - 1);
				check[current - 1] = true;
			}
			// 앞으로 한칸
			if (current < 100000 && check[current + 1] == 0) {
				q.push(current + 1);
				check[current + 1] = true;
			}
			// 2배로 순간이동
			if (current * 2 < 100001 && check[current * 2] == 0) {
				q.push(current * 2);
				check[current * 2] = true;
			}
		}
		time++;
	}
}

int main() {
	cin >> N >> K;
	cout << bfs(N);
	return 0;
}