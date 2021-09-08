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
	cin >> n >> c;	// ��,������

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());

	/* 
	1. �־��� ������ ��ǥ�� ������������ �����Ѵ� (�̺� Ž���� �⺻ ����).
	2. ���� ������ �Ÿ��� �ʱ�ȭ�Ѵ�. �ּڰ��� 1�̸�, �ִ��� ������ ù�� ������ �Ÿ��̴�.
	3. ���� ������ �Ÿ��� �������� �̺� Ž���� �����Ѵ�. �־��� ���� (mid)���� �����⸦ ��ġ���� ��, 
	   �־��� ������ �����ϴ��� Ȯ���Ѵ�.
	4. 3���� �����ϴ� �Ÿ��� �� �ִ��� ����Ѵ�.
	*/

	int left = 1;					// ���� ������ �ּҰ�
	int right = v[n - 1] - v[0];	// ���� ������ �ִ밪
	int answer = 0;

	while (left <= right) {
		int mid = (left + right) / 2;	// mid
		int start = v[0];
		int cnt = 1;

		for (int i = 1; i < n; i++) {
			// �Ÿ� Ȯ��, ��ġ������ ������ ���� üũ
			if (mid <= v[i] - start) {
				cnt++;
				start = v[i];
			}
		}

		// ������ ���Ѱ������� �� �������
		if (cnt >= c) {
			answer = max(answer, mid);
			left = mid + 1;
		}
		// ������ ���Ѱ������� �������
		else {
			right = mid - 1;
		}
	}
	cout << answer;
}