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

	// ť�� �������� �ݺ�
	while (!q.empty()) {
		int size = q.size();

		for (int i = 0; i < size; i++) {
			current = q.front();
			q.pop();
			if (current == K) {
				return time;
			}
			
			// �ڷ� ��ĭ
			if (current > 0 && check[current - 1] == 0) {
				q.push(current - 1);
				check[current - 1] = true;
			}
			// ������ ��ĭ
			if (current < 100000 && check[current + 1] == 0) {
				q.push(current + 1);
				check[current + 1] = true;
			}
			// 2��� �����̵�
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