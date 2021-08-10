#include <iostream>
#include <queue>
#include <vector>

#define MAX_SIZE 11

using namespace std;

int dp[MAX_SIZE];

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	
	int tc; cin >> tc;

	dp[0] = 1;
	dp[1] = 1;	// 1
	dp[2] = 2;	// 1+1 , 2

	// �� ���� ǥ���� �ǳ��� 1, 2, 3 ���� ��������
	// �ǳ��� + 1 �ΰ��� dp[i-1] , +2 �ΰ��� dp[i-2], +3 �ΰ��� dp[i-3] �̴�.
	// �� dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
	for (int i = 3; i < MAX_SIZE; i++) {
		dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
	}

	while (tc--) {
		int n; cin >> n;
		cout << dp[n] << "\n";
	}
}