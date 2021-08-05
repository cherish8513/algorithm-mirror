#include <iostream>
#include <string>
#include <vector>
#include <cstring>

using namespace std;

int dx[] = { -1,0,1,-1,1,-1,0,1 };
int dy[] = { -1,-1,-1,0,0,1,1,1 };

int map[52][52];
bool check[52][52];
int sum = 0;

void dfs(int x, int y) {
	check[y][x] = true;

	for (int i = 0; i < 8; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (map[ny][nx] == 1 && !check[ny][nx]) {
			dfs(nx, ny);
		}
	}
}

int main() {
	while (true) {
		int w, h;
		cin >> w >> h;

		// 탈출 조건
		if (w == 0 && h == 0) break;

		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				int num;
				cin >> num;
				map[i][j] = num;
			}
		}
		// input eof

		// solution

		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				if (map[i][j] == 1 && !check[i][j]) {
					sum++;
					dfs(j, i);
				}
			}
		}
		cout << sum << "\n";

		// 다음 문제를 위해 초기화
		memset(map, 0, sizeof(map));
		memset(check, false, sizeof(check));
		sum = 0;
	}
}