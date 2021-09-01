#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

#define INF 9e8

using namespace std;

int tc, N, D, C;

int main() {
	cin >> tc;
	while (tc--) {
		cin >> N >> D >> C;
		vector<vector<pair<int, int>>> v(N + 1);
		vector<int> dist(N + 1, INF);
		for (int i = 0; i < D; i++) {
			int a, b, c;
			cin >> a >> b >> c;
			v[b].push_back({ a,c });
		}

		// 다익스트라
		priority_queue<pair<int, int>> pq;
		dist[C] = 0;		// 감염된 컴퓨터거리 = 0
		pq.push({ C,0 });	// 감염당한 컴퓨터 부터 시작
		while (!pq.empty()) {

			auto node = pq.top(); pq.pop();

			if (dist[node.first] < -node.second) continue;

			for (auto p : v[node.first]) {
				int nxt = p.first, cost = p.second;
				if (dist[nxt] > dist[node.first] + cost) {
					dist[nxt] = dist[node.first] + cost;
					pq.push({ nxt,dist[nxt] });
				}
			}
		}
		int cnt = 0, mx = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[i] != INF) {
				cnt++;
				mx = max(mx, dist[i]);
			}
		}
		cout << cnt << " " << mx << '\n';
	}
}