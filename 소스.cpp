#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
char map[101][101];
int check[101][101];	// 0 : 미방문, 1 : W, 2 : B
int w, b;
int sum;

int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

void dfs(int x, int y,int num) {
	char c = num == 1 ? 'W' : 'B';
	check[y][x] = num;	// 현재 탐색중인 병사로 check 채우기
	sum++;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[ny][nx] == c && check[ny][nx] == 0) {
			dfs(nx, ny, num);
		}
	}
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < n; j++) {
			map[i][j] = s[j];
		}
	}// eof input

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (check[i][j] == 0) {
				sum = 0;
				if (map[i][j] == 'W') {
					dfs(j, i, 1);	// W 찾기
					w += sum * sum;
				}
				else if(map[i][j] == 'B'){
					dfs(j, i, 2);	// B 찾기
					b += sum * sum;
				}
			}
		}
	}
	cout << w << " "<< b;
}