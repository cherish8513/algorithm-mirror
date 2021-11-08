#include <iostream>
#include <queue>
#include <map>

using namespace std;

map<int, int> dist;
map<int, int> from;
map<int, bool> check;

void print(int n, int start) {
	if (n != start) {
		print(from[n], start);
	}
	cout << n << " ";
}

int main() {
	int N;
	cin >> N;

	dist[N] = 1;

	queue<int> q;
	check[N] = true;
	dist[N] = 0;
	q.push(N);

	while (!q.empty()) {
		int now = q.front();
		q.pop();

		int next;

		if (now == 1) {
			break;
		}

		if (now % 3 == 0) {
			next = now / 3;
			if (check[next] == false) {
				q.push(next);
				check[next] = true;
				dist[next] = dist[now] + 1;
				from[next] = now;

			}
		}

		if (now % 2 == 0) {
			next = now / 2;
			if (check[next] == false) {
				q.push(next);
				check[next] = true;
				dist[next] = dist[now] + 1;
				from[next] = now;

			}
		}

		next = now - 1;
		if (check[next] == false) {
			q.push(next);
			check[next] = true;
			dist[next] = dist[now] + 1;
			from[next] = now;

		}
	}

	cout << dist[1] << endl;
	print(1, N);
}