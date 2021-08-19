#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

long long dp[21][101];
// row : ���� ����� �ִ¼��� , col : ����� ����
// �� : ����� �ִ� ����� ��

int main() {
	int n; cin >> n;
	vector<int> v;

	for (int i = 0; i < n; i++) {
		int num; cin >> num;
		v.push_back(num);
	}
	
	dp[v[0]][0] = 1;	// �ʱ�ȭ

	for (int j = 1; j < n - 1; j++) {
		for (int i = 0; i < 21; i++) {
			if (dp[i][j - 1] == 0)
				continue;

			int cur = v[j];

			// ����
			if (i + cur <= 20) {
				dp[i + cur][j] += dp[i][j - 1];
			}

			// ����
			if (i - cur >= 0) {
				dp[i - cur][j] += dp[i][j - 1];
			}
		}
	}

	int r = v.back();
	int c = n - 2;
	cout << dp[r][c];
}