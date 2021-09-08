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
	cin >> n >> m;	// ��������, �ʿ��� ����

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());

	long long left = 0;			// �ּҰ�
	long long right = v[n - 1];	// �ִ밪
	long long answer = 0;

	while (left <= right) {
		long long mid = (right + left) / 2;
		long long sum = 0;

		for (auto& i : v) {
			// ���ܱ� ���̺��� ������ ��ٸ� ����
			if (mid < i) {
				sum += i - mid;	// ������ ����
			}
		}

		// ������ ������ �纸�� ����ì��ٸ�
		if (sum >= m) {
			answer = max(mid, answer);
			left = mid + 1;		// ���ܱ� +
		}
		// ������ ������ �纸�� ����ì��ٸ�
		else {
			right = mid - 1;	// ���ܱ� -
		}
	}
	cout << answer;
}