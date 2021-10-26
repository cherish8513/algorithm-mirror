#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int N, M, result;
vector<int> v;

bool check(int mid) {
	int money = mid;
	int cnt = 1;
	for (int i = 0; i < N; i++) {
		// 만약 인출가능돈보다 써야할돈이 더 많으면 무조건 false
		if (mid < v[i]) {
			return false;
		}

		// 남은돈 - 지금쓸돈 < 0
		if (money - v[i] < 0) {
			cnt++;
			money = mid;
		}
		// 사용한돈 빼주기
		money -= v[i];
	}

	return M >= cnt;
}

int main() {
	cin >> N >> M;

	int temp = 0;
	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		v.push_back(num);
		temp += num;
	}

	int left = 1;
	int right = temp;

	while (left <= right) {
		int mid = (left + right) / 2;

		if (check(mid)) {
			result = mid;
			right = mid - 1;
		}
		else {
			left = mid + 1;
		}
	}
	cout << result;
}