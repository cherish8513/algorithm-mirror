#include <iostream>
#include <algorithm>
using namespace std;

int map[15][15]; 
int n, k,t;

bool down(int y, int x) {
	// 끝자리가 아닐때
	if (y > 0 && map[y - 1][x] == 1) 
		return false;
	// 맨끝자리가 빈칸일때
	if (y + k < n && map[y + k][x] == 1) 
		return false;
	// 중간값들 확인
	for (int i = 0; i < k; i++) {
		if (map[y + i][x] != 1) return false;
	}
	return true;
}
bool right(int y, int x) {
	if (x > 0 && map[y][x - 1] == 1) 
		return false;
	if (x + k < n && map[y][x + k] == 1) 
		return false;
	for (int i = 0; i < k; i++) {
		if (map[y][x + i] != 1) return false;
	}
	return true;
}
int main() {
	cin >> t;
	for (int tc = 1; tc <= t; tc++) {
		cin >> n >> k;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int num; cin >> num;
				map[i][j] = num;
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					if (i + k <= n && down(i, j)) count++;
					if (j + k <= n && right(i, j)) count++;
				}
			}
		}
		printf("#%d %d\n", tc, count);
	}
}