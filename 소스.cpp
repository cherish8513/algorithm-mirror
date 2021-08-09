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

	// ������ ���� �����ϸ� answer ++;
	if (x == c - 1) {
		return true;
	}

	for (int i = 0; i < 3; i++) {
		int ny = dy[i] + y;
		int nx = dx[i] + x;

		// y ���� �����, �� Ȥ�� �������� ������ �Ѿ��
		if (ny < 0 || nx < 0 || ny >= r || nx >= c || map[ny][nx] == 'x') {
			continue;
		}

		// go �ǹ�ȯ���� true -> ������ ���ῡ �����ߴ�.
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