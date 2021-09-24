#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
	// 수업 시작시간과 끝시간을 저장할 우선순위큐
	priority_queue<pair<int, int> ,vector<pair<int,int>>, greater<pair<int,int>>> pq;
	// 각 수업시간의 끝시간만 저장할 우선순위큐 -> 이 큐의 값이 곧 강의실
	priority_queue<int, vector<int>, greater<int>> endq;
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int start, end;
		cin >> start >> end;
		pq.push({start, end});
	}// eof input


	while (!pq.empty()) {
		// 정렬된 수업을 꺼내 강의실에 배정하기
		pair<int, int> cur = pq.top(); pq.pop();

		// 현재 강의실이 없다면 새로운 강의실을 생성
		if (endq.empty()) {
			endq.push(cur.second);
		}
		else {
			// 존재하는 강의실의 종료시간 중 최소값과
			// 현재 강의의 시작시간이 크거나 같다면
			// 해당 강의실에 할당가능 -> 시간갱신
			if (cur.first >= endq.top()) {
				endq.pop();
				endq.push(cur.second);
			}
			// 그렇지 않다면, 새로운 강의실에 배정
			else {
				endq.push(cur.second);
			}
		}
	}
	cout << endq.size();
	return 0;
}
