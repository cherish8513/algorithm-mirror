#include <iostream>
#include <queue>
#include <cstring>
#include <vector>

using namespace std;

int m, n;			// ����, ����
int map[51][51];
bool check[51][51];
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

void go(int x, int y) {
	// ���� ��ġ �湮����
	check[y][x] = true;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		// �׵θ� + �湮����
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
				// ���߰� �ְ� �湮���� ���� ��ġ���� dfs ���� 
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