#include <iostream>
#include <queue>
#include <vector>

#define MAX_SIZE 1001

using namespace std;

int dp[MAX_SIZE];

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	
	int n; cin >> n;
	// eof input

	dp[0] = 0;
	dp[1] = 1;
	dp[2] = 3;

	for (int i = 3; i < MAX_SIZE; i++) {
		dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
	}

	cout << dp[n];
}