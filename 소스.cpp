#include <iostream>
#include <algorithm>

#define SIZE 501

using namespace std;

int arr[SIZE];
int dp[SIZE];

int main() {
	int n;
	cin >> n;

	int max = 0;	// 가장 큰 전기줄 인덱스
	for (int i = 0; i < n; i++) {
		int start, end;
		cin >> start >> end;
		arr[start] = end;
		dp[start] = 1;
	}
	// eof input

	// i가 시작숫자 , j가 도착숫자
	for (int i = 1; i < SIZE; i++) {
		for (int j = 1; j < i; j++) {
			if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
				dp[i] = dp[j] + 1;
			}
		}
	}

	//for (int i = 1; i < 100; i++) {
	//	cout << arr[i] << " ";
	//}
	//cout << endl;
	//for (int i = 1; i < 100; i++) {
	//	cout << dp[i] << " ";
	//}

	cout << n - *max_element(dp, dp + SIZE);
}