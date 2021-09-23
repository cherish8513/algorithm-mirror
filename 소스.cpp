#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<long long> v;
long long n, k;

int main() {
	ios::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);

	cin >> n;

	for (long long i = 0; i < n; i++) {
		long long num;
		cin >> num;
		v.push_back(num);
	}
	cin >> k;

	// 분할정복인척하지만 사실 정렬만 해주면 끝임
	k = n / k;
	for (int i = 0; i < n; i += k) {
		sort(v.begin() + i, v.begin() + i + k);
	}

	for (auto& i : v) {
		cout << i << " ";
	}
}