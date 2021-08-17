#include <iostream>

using namespace std;

int n, m, h;
int ladder[30][11];
bool check;
int cnt;

// y : y좌표, c : 사용한 사다리 개수
void dfs(int y, int c) {
	if (check)		// 이미 답을 찾았다면 return
		return;

	if (c == cnt)
	{
		bool flag = true;
		for (int i = 1; i <= n; i++) {
			int col = i;
			for (int j = 0; j < h; j++) {
				// 사다리가 있으면 가로 이동
				if (ladder[j][col]) {
					col++;
				}
				else if (col > 1 && ladder[j][col - 1]) {
					col--;
				}
			}

			// 동일한 위치로 내려가지 못했다면
			if (i != col) {
				flag = false;
				break;
			}
		}
		// 전부다 동일한 위치로 올라갔다면
		if (flag) {
			check = true;
		}
			
		return;
	}

	for (int i = y; i < h; i++) {
		for (int j = 1; j < n; j++) {
			//두 가로선이 연속하거나 서로 접하면 안된다
			if (!ladder[i][j - 1] && !ladder[i][j] && !ladder[i][j + 1])
			{
				ladder[i][j] = true;
				dfs(i, c + 1);
				ladder[i][j] = false;
			}
		}
	}
		
	return;
}

int main() {
	cin >> n >> m >> h;

	for (int i = 0; i < m; i++) {
		int y, x;
		cin >> y >> x;
		// y에서 x -> x+1 를 이어주는 사다리
		ladder[y-1][x] = true;
	}

	// 사다리 0~3개 설치
	for (int i = 0; i <= 3; i++) {
		cnt = i;
		dfs(0, 0);
		if (check)
			break;
	}
	if (check) 
		cout << cnt;
	else 
		cout << -1;
}