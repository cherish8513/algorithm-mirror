#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);

	vector<int> v;
	int n, c;
	cin >> n >> c;	// 집,공유기

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());

	/* 
	1. 주어진 집들의 좌표를 오름차순으로 정렬한다 (이분 탐색의 기본 조건).
	2. 집들 사이의 거리를 초기화한다. 최솟값은 1이며, 최댓값은 끝집과 첫집 사이의 거리이다.
	3. 집들 사이의 거리를 기준으로 이분 탐색을 진행한다. 주어진 간격 (mid)으로 공유기를 설치했을 때, 
	   주어진 조건을 충족하는지 확인한다.
	4. 3번을 만족하는 거리들 중 최댓값을 출력한다.
	*/

	int left = 1;					// 집들 사이의 최소값
	int right = v[n - 1] - v[0];	// 집들 사이의 최대값
	int answer = 0;

	while (left <= right) {
		int mid = (left + right) / 2;	// mid
		int start = v[0];
		int cnt = 1;

		for (int i = 1; i < n; i++) {
			// 거리 확인, 설치가능한 공유기 개수 체크
			if (mid <= v[i] - start) {
				cnt++;
				start = v[i];
			}
		}

		// 공유기 제한갯수보다 더 적을경우
		if (cnt >= c) {
			answer = max(answer, mid);
			left = mid + 1;
		}
		// 공유기 제한개수보다 많을경우
		else {
			right = mid - 1;
		}
	}
	cout << answer;
}