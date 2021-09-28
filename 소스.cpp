#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int map[502][502];
bool visit[502][502];

int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };

int depth;
int cnt, result;

void dfs(int y,int x) {
	depth++;
	visit[y][x] = true;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if(!visit[ny][nx] && map[ny][nx] == 1)
			dfs(ny, nx);
	}
}

int main() {
	int n, m;	// 세로,가로
	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> map[i][j];
		}
	}
	//eof input

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (!visit[i][j] && map[i][j]) {
				depth = 0;
				dfs(i, j);
				result = max(result, depth);
				cnt++;
			}
		}
	}
	cout << cnt << endl << result;
}