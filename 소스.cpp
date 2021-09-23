#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 비교함수
bool compair(pair<int, int> t1, pair<int, int> t2) {
	if (t1.second == t2.second)
		return t1.first < t2.first;	// first를 우선 비교
	else
		return t1.second < t2.second;
}

int main() {
	int answer = 0;
	int N;
	cin >> N;

	vector<pair<int, int>> times;
	for (int i = 0; i < N; i++) {
		pair<int, int> time;
		int t1, t2;
		cin >> t1 >> t2;
		time.first = t1;
		time.second = t2;
		times.push_back(time);
	}

	sort(times.begin(), times.end(), compair);

	int eTime = times[0].second;
	answer++;
	for (int i = 1; i < N; i++) {
		// 겹치지 않음.
		if (times[i].first >= eTime) {
			answer++;
			eTime = times[i].second;
		}
	}
	cout << answer;
}