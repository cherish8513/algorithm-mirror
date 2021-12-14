#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

#define CLEAN 2

using namespace std;

int result;
int n, m;		// 맵크기
int y, x, d;	// 로봇위치,방향
int map[50][50];

// 북동남서
int dy[] = { -1,0,1,0 };
int dx[] = { 0,-1,0,1 };

// 해당 방향을 볼때 왼쪽타일
int lx[] = { -1,0,1,0 };
int ly[] = { 0,1,0,-1 };

void print() {
	cout << endl;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << map[i][j] <<" ";
		}
		cout << endl;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	cin >> y >> x >> d;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}

	while (true) {
		cout << x << ", " << y <<", "<<d<< "청소완료 -> ";
		// 1. 현재위치를 청소한다.
		if (map[y][x] == 0) {
			map[y][x] = CLEAN;
			result++;
		}

		// 2. 현재 위치에서 현재 방향을 기준으로 
		// 2. 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
		bool temp = false;
		for (int k = 0; k < 4; k++) {
			int leftx = x + lx[(d + k) % 4];
			int lefty = y + ly[(d + k) % 4];
			// 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면
			if (map[lefty][leftx] == 0) {
				//cout << leftx << "," << lefty << " 청소할공간 발견 ";
				// 그 방향으로 회전
				d = (d + 1 + k) % 4;
				// 전진후 1번으로
				y += dy[d];
				x += dx[d];
				temp = true;
				break;
			}
		}

		// 네방향 모두 청소가 되어있거나 벽인경우에는
		// 바라보는 방향을 유지하면서 뒤로 후진
		if (!temp) {
			if (map[y + dy[(d + 2) % 4]][x + dx[(d + 2) % 4]] == 1) {
				// 후진하려는데 벽이면 종료
				cout << "종료" << endl;
				break;
			}
			else {
				cout << "후진" << endl;
				y += dy[(d + 2) % 4];
				x += dx[(d + 2) % 4];
			}
		}
		print();
		cout << endl;
	}

	cout << result;
}

//6 6
//2 1 3
//1 1 1 1 1 1
//1 0 0 0 0 1
//1 0 1 1 1 1
//1 0 1 1 1 1
//1 0 1 1 1 1
//1 1 1 1 1 1
// 답 : 7
// 이라는데 5아님 ??????
// 후진때리다가 벽에막히는게 맞지않나