#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int dp[1001][1001];

int main() {
	int n, m;
	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		string s;
		cin >> s;
		for (int j = 1; j <= m; j++) {
			dp[i][j] = s[j-1] - '0';
		}
	}// eof input

	int max = 0;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= m; j++)
		{
			if (dp[i][j] >= 1) {
				dp[i][j] = min(dp[i][j - 1], min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;

				if (max < dp[i][j])
					max = dp[i][j];
			}
		}
	}

	cout << max*max;
}