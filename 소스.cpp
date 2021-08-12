#include <string>
#include <vector>
#include <iostream>

#define MAX 502

using namespace std;

int n, m, answer = 0;
int map[MAX][MAX];
int dp[MAX][MAX];

int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

void print() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << dp[i][j] << " ";
		}
		cout << "\n";
	}
	cout << "\n";
}

int dfs(int y, int x) {
	if (x == m - 1 && y == n - 1) return 1;
	// 현재위치가 이미 방문한곳이라면 반환
	if (dp[y][x] != -1) return dp[y][x];

	dp[y][x] = 0;	// 방문여부 체크
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && ny >= 0 && ny < n && nx < m)
		{
			// 방문안한곳이고 내리막길이면 재귀 ㄱㄱ
			if (map[y][x] > map[ny][nx]) {
				dp[y][x] = dp[y][x] + dfs(ny, nx);
			}
		}
	}

	return dp[y][x];
}

int main() {
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
			dp[i][j] = -1;
		}
	}
	// eof input

	cout << dfs(0, 0) << endl;
}