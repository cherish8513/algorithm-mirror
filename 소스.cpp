#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
	int N, K;
	cin >> N >> K;

	queue<int> q;

	// input
	for (int i = 1; i <= N; i++) {
		q.push(i);
	}

	cout << "<";
	while (!q.empty()) {
		// K-1 개를 큐 뒤로 보낸다.
		for (int i = 0; i < K - 1; i++) {
			q.push(q.front());
			q.pop();
		}
		cout << q.front();
		if (q.size() != 1) 
			cout << ", ";
		q.pop();
	}
	cout << ">";
}