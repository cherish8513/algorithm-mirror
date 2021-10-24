#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

#define S 60	// 3.1
#define E 335	// 12.1

// �� ���� ��ĥ���� ����
int monthArr[] = {
	0,
	31, 28, 31,
	30, 31, 30,
	31, 31, 30,
	31, 30, 31
};

// ��¥�� ���ڷ� ��ȯ
int dayToNum(int month, int day) {
	int sum = 0;
	
	for (int i = 0; i < month; i++) 
		sum += monthArr[i];
	
	sum += day;
	return sum;
}

int main() {
	int N;
	cin >> N;

	vector<pair<int, int>> v;
	for (int i = 0; i < N; i++) {
		int m1, d1, m2, d2;
		cin >> m1 >> d1 >> m2 >> d2;

		int num1 = dayToNum(m1, d1);
		int num2 = dayToNum(m2, d2);

		// ���۳�¥�� 3/1���� ������ 3/1�� ����
		if (num1 < S) {
			num1 = S;
		}
		// ������ ��¥�� 11/30 ���� ũ�� 11/30���κ���
		if (num2 >= E) {
			num2 = E;
		}

		// �� ��¥�� ���ڷ� ��ȯ�ؼ� ����
		v.push_back({ num1,num2 });
	}
	sort(v.begin(), v.end());

	int start = -1;
	int end = 0;
	int result = 0;

	for (int i = S; i < E; i = end) {
		bool flag = false;
		start++;

		for (int j = start; j < v.size(); j++) {
			// 
			if (v[j].first > i) {
				break;
			}

			// ���ν��� ���� �̹̽������� ������ ��¥���� ũ��
			if (end < v[j].second) {
				end = v[j].second;
				start = j;
				flag = true;
			}
		}

		if (flag)
			result++;
		else {
			cout << 0 << endl;
			return 0;
		}
	}
	cout << result << endl;
}