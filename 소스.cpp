#include <iostream>
#include <algorithm>
#include <queue>
#include <unordered_map>

using namespace std;

int N, K, M;
int visit[100001];

// 입력받은 문자열 -> 10진수
int stringToInteger(string s) {
	int sum = 0;
	for (int i = 0; i < s.length(); i++) {
		sum += (s[i] - '0') * (1 << i);
	}
	return sum;
}

int main() {
	cin >> N >> K;

	unordered_map<int, int> um;
	int start = 0;

	for (int i = 0; i <= N; i++) {
		visit[i] = -1;
	}// init visit

	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;
		um[stringToInteger(s)] = i + 1;

		if (i == 0)
			start = stringToInteger(s);
	}// eof input

	// bfs start
	queue<int> q;
	q.push(start);
	visit[1] = 1;

	while (!q.empty()) {
		int val = q.front();
		int idx = um[val];
		q.pop();

		for (int i = 0; i < K; i++) {
			int nextVal = val ^ (1 << i);

			// val ^ (1 << i) 이 존재하는지 찾는다
			if (um.find(nextVal) != um.end()) {
				int nextIdx = um[nextVal];
				if (visit[nextIdx] == -1) {
					q.push(nextVal);		// bfs
					visit[nextIdx] = idx;	// 방문여부 체크
				}
			}
		}
	}

	cin >> M;
	for (int i = 0; i < M; i++) {
		int num;
		cin >> num;

		vector<int> v;

		if (visit[num] == -1) {
			cout << "-1";
		}
		else {
			while (true) {
				v.push_back(num);
				if (num == 1)
					break;
				num = visit[num];
			}
		}

		for (int i = v.size() - 1; i >= 0; i--) {
			cout << v[i] << " ";
		}
		cout << "\n";
	}
}