#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);

	vector<long long> v;
	long long n, m;
	cin >> n >> m;	// 나무개수, 필요한 길이

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());

	long long left = 0;			// 최소값
	long long right = v[n - 1];	// 최대값
	long long answer = 0;

	while (left <= right) {
		long long mid = (right + left) / 2;
		long long sum = 0;

		for (auto& i : v) {
			// 절단기 높이보다 나무가 길다면 절단
			if (mid < i) {
				sum += i - mid;	// 절단한 나무
			}
		}

		// 나무를 정해진 양보다 적게챙겻다면
		if (sum >= m) {
			answer = max(mid, answer);
			left = mid + 1;		// 절단기 +
		}
		// 나무를 정해진 양보다 많이챙겻다면
		else {
			right = mid - 1;	// 절단기 -
		}
	}
	cout << answer;
}