#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	int n, k;
	cin >> n >> k;

	vector<int> v;	// ���� ����
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		v.push_back(num);
	}

	sort(v.begin(), v.end());

	vector<int> dis_v;	//�� �������� ���ݺ���
	for (int i = 1; i < n; i++) {
		dis_v.push_back(v[i] - v[i - 1]);
	}

	sort(dis_v.begin(), dis_v.end());

	// k-1����ŭ ������ ū�κ��� �����Ҽ��ִ�.
	int result = 0;
	for (int i = 0; i < n - k; i++) {
		result += dis_v[i];
	}
	cout << result;
}