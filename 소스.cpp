#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

#define S 60	// 3.1
#define E 335	// 12.1

// 각 월이 며칠인지 저장
int monthArr[] = {
	0,
	31, 28, 31,
	30, 31, 30,
	31, 31, 30,
	31, 30, 31
};

// 날짜를 숫자로 변환
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

		// 시작날짜가 3/1보다 작으면 3/1로 변경
		if (num1 < S) {
			num1 = S;
		}
		// 끝나는 날짜가 11/30 보다 크면 11/30으로변경
		if (num2 >= E) {
			num2 = E;
		}

		// 두 날짜를 숫자로 변환해서 저장
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

			// 새로심을 꽃이 이미심은꽃의 마지막 날짜보다 크면
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