#include <iostream>
#include <queue>
#include <string>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;
	queue<int> q;
	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;

		if (s == "push") {
			int n; cin >> n;
			q.push(n);
		}
		else if (s == "pop") {
			if (q.empty()) {
				cout << "-1" << '\n';
			}
			else {
				cout << q.front() << '\n';
				q.pop();
			}
		}
		else if (s == "front") {
			if (!q.empty())
				cout << q.front() << '\n';
			else
				cout << -1 << '\n';
		}
		else if (s == "back") {
			if (!q.empty())
				cout << q.back() << '\n';
			else
				cout << -1 << '\n';
		}
		else if (s == "size") {
			cout << q.size() << '\n';
		}
		else if (s == "empty") {
			if (q.empty())
				cout << 1 << '\n';
			else
				cout << 0 << '\n';
		}
	}
}