#include <iostream>

int stiker[2][100010];
int dp[2][100010];

using namespace std;

int max(int a, int b)
{
	return a > b ? a : b;
}
int main(void) {

	int testcase;
	cin >> testcase;
	while (testcase--) {
		int n;
		cin >> n;

		for (int i = 0; i < 2; i++)
			for (int j = 2; j <= n + 1; j++) {
				int num; cin >> num;
				stiker[i][j] = num;
			}

				


		for (int i = 2; i <= n + 1; i++) {
			dp[0][i] = max(max(dp[0][i - 1], dp[1][i - 1] + stiker[0][i]), dp[1][i - 2] + stiker[0][i]);
			dp[1][i] = max(max(dp[1][i - 1], dp[0][i - 1] + stiker[1][i]), dp[0][i - 2] + stiker[1][i]);
		}


		if (dp[0][n + 1] > dp[1][n + 1])
			printf("%d\n", dp[0][n + 1]);
		else
			printf("%d\n", dp[1][n + 1]);
	}

	return 0;
}