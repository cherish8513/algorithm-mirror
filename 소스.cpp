#include <iostream>
#include <queue>
#include <vector>

#define R 10000
#define C 500

using namespace std;

int r, c, answer = 0;
char map[R][C];
int dx[] = { 1,1,1 };
int dy[] = { -1,0,1 };

bool go(int y, int x) {
	map[y][x] = 'x';

	// 마지막 열에 도착하면 answer ++;
	if (x == c - 1) {
		return true;
	}

	for (int i = 0; i < 3; i++) {
		int ny = dy[i] + y;
		int nx = dx[i] + x;

		// y 범위 벗어나면, 집 혹은 파이프가 있으면 넘어가기
		if (ny < 0 || nx < 0 || ny >= r || nx >= c || map[ny][nx] == 'x') {
			continue;
		}

		// go 의반환값이 true -> 파이프 연결에 성공했다.
		if (go(ny, nx)) return true;
		
		//map[ny][nx] = '.';
	}
	return false;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	cin >> r >> c;

	for (int i = 0; i < r; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < c; j++) {
			map[i][j] = s[j];
		}
	}
	// eof input

	for (int i = 0; i < r; i++) {
		if(go(i, 0))
			answer++;
	}
	cout << answer;
}