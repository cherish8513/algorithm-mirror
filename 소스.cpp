#include<iostream>
#include<algorithm>
using namespace std;

int n, m;
bool arr[501][501];
bool friends[501];
bool sangen_freinds[501];

int main() {
	cin >> n >> m;

	// 관계 입력
	for (int i = 0; i < m; i++) {
		int n1, n2;
		cin >> n1 >> n2;

		// 이거 꼭 해야 되더라?
		arr[n1][n2] = true;
		arr[n2][n1] = true;
	}

	// 상근이의 친구
	for (int i = 2; i <= n; i++) {
		if (arr[1][i] == true) {
			friends[i] = true;
			sangen_freinds[i] = true;
		}
	}

	// 상근이의 친구의 친구
	for (int i = 2; i <= n; i++) {
		if (sangen_freinds[i]) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j])
					friends[j] = true;
			}
		}
	}

	int result = 0;
	for (int i = 2; i <= n; i++)
		if (friends[i])
			result++;
	cout << result;
}