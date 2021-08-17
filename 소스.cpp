#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main() {
	int n; cin >> n;

	vector<long> v;
	queue<long> q;

	for (int i = 0; i <= 9; i++) {
		v.push_back(i);
		q.push(i);
	}

	while (!q.empty()) {
		long current = q.front();
		q.pop();

		int size = current % 10;	// �����ڸ� ���ڰ�
		// current�� �����ڸ����� ���������� �ڿ� ������.
		for (int i = 0; i < size; i++) {
			long n = 10 * current + i;
			v.push_back(n);
			q.push(n);
		}
	}

	cout << ((n > v.size()) ? -1 : v[n - 1]);
}