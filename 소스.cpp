#include <iostream>
#include <vector>
#include <algorithm>

#define SIZE 201
#define MOD 1000000000

using namespace std;

long dp[SIZE][SIZE];

int main() {
	int n, k;
	cin >> n >> k;

	for (int i = 0; i <= n; i++) {
		dp[1][i] = 1;
	}

	// �� : k (���� ����)
	// �� : n (���� ����)
	for (int i = 2; i <= k; i++) {
		for (int j = 0; j <= n; j++) {
			// dp[i-1][0]���� dp[i-1][j] ��������
			for (int t = 0; t <= j; t++) {
				dp[i][j] += dp[i - 1][t];
			}
			dp[i][j] %= MOD;
		}
	}

	cout << dp[k][n];
}