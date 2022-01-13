#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/*
분류봣음
두포인터에 이분탐색?
두포인터로 2개를 고르고 남은 하나를 이분탐색 하는식으로 알고리즘 생각함
두포인터 = 2n = O(n)
이분탐색 = logn = O(logn)
원하는 이분탐색 값을 찾기 = n

==> O(n^2 logn)
n은 최대 5000
대략적으로 1초안에 가능할것
*/



int main() {
	int n;
	cin >> n;
	vector<long long> v;
	vector<long long> ansv(3, 0);
	long long answer = 3000000001;

	for (int i = 0; i < n; i++) {
		long long num;
		cin >> num;
		v.push_back(num);
	}

	sort(v.begin(), v.end());

	for (int m = 0; m < n - 2; m++) {
		int s = m + 1, e = n - 1;

		//cout << v[m] << ", " << v[s] << ", " << v[e] << "     /     ";

		while (s < e) {
			long long sum = v[s] + v[m] + v[e];
			if (abs(sum) < answer) {
				answer = abs(sum);
				ansv[0] = v[m];
				ansv[1] = v[s];
				ansv[2] = v[e];

				//cout << ansv[0] << ", " << ansv[1] << ", " << ansv[2] <<" = "<<sum<< endl;
			}
			if (sum < 0)
				s++;
			else
				e--;
		}
	}
	for (auto& i : ansv) {
		cout << i << " ";
	}
}