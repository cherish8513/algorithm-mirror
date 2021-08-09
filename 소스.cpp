#include <iostream>
#include <queue>
#include <cstring>
#include <vector>

using namespace std;

int m, n;			// 가로, 세로
int map[51][51];
bool check[51][51];
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

void go(int x, int y) {
	// 현재 위치 방문여부
	check[y][x] = true;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		// 테두리 + 방문여부
		if (nx >= 0 && ny >= 0 && nx < m && ny < n && !check[ny][nx] && map[ny][nx] == 1) {
			go(nx, ny);
		}
	}
}

int main() {
	int tc; 
	cin >> tc;

	for (int i = 0; i < tc; i++) {
		int k, answer = 0;
		cin >> m >> n >> k;

		for (int i = 0; i < k; i++) {
			int x, y;
			cin >> x >> y;
			map[y][x] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 배추가 있고 방문한적 없는 위치에서 dfs 시작 
				if (!check[i][j] && map[i][j] == 1) {
					go(j, i);
					answer++;
				}
			}
		}
		cout << answer << "\n";

		memset(map, 0, sizeof(map));
		memset(check, 0, sizeof(check));
	}
}