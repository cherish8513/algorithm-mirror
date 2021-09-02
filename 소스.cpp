#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int R, C, T;		// input
int map[51][51];	// 맵
int copy_map[51][51];
int head, body;		// 공기청정기 머리와 몸통
int dust_sum;		// answer

int dr[4] = { 0, 1, 0, -1 };
int dc[4] = { -1, 0, 1, 0 };

// 먼지 확산
void dust() {
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			// 먼지가 있는장소에서만 확산
			if (map[i][j] == 0 || map[i][j] == -1)
				continue;

			int dust_value = map[i][j] / 5;	// 확산된 먼지하나의 양
			int dust_cnt = 0;				// 확산된 먼지의 개수

			for (int k = 0; k < 4; k++) {
				int nr = i + dr[k];
				int nc = j + dc[k];

				// 범위 벗어나면 먼지 안생김
				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				// 공기청정기 만나도 먼지 안생김
				if (map[nr][nc] == -1)
					continue;
				copy_map[nr][nc] += dust_value;	// 
				dust_cnt++;		// 먼지 개수+1
			}

			// 먼지의 개수 * 먼지의 양만큼 제거
			// 미리 빼둬야 업데이트할때 기존의 값에서 빠진다.
			copy_map[i][j] -= dust_cnt * dust_value;	
		}
	}

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			map[i][j] += copy_map[i][j];
			copy_map[i][j] = 0;
		}
	}
}

void air_cleaner() {
	// 공기청정기 위,아래칸은 어차피 무조건 범위에서 안벗어남
	// 열심히 돌아봣자 미세먼지 빨아들이는건 바로 위아래칸 뿐
	dust_sum -= map[head - 1][0];	
	dust_sum -= map[body + 1][0];

	// 위쪽 공기 순환, 공기순환 반대방향으로 순환
	// 1. 왼쪽 
	for (int i = head - 1; i > 0; i--) {
		map[i][0] = map[i - 1][0];
	}
	// 2. 위쪽
	for (int i = 0; i < C - 1; i++) {
		map[0][i] = map[0][i + 1];
	}
	// 3. 오른쪽
	for (int i = 1; i <= head; i++) {
		map[i - 1][C - 1] = map[i][C - 1];
	}
	// 4. 아래쪽
	for (int i = C - 1; i > 1; i--) {
		map[head][i] = map[head][i - 1];
	}
	map[head][1] = 0;	// 밀어낸 공간이므로 끝자리는 무조건 0

	// 아래 공기 순환
	// 1. 왼쪽
	for (int i = body + 1; i < R - 1; i++)
		map[i][0] = map[i + 1][0];
	// 2. 아래쪽
	for (int i = 0; i < C - 1; i++)
		map[R - 1][i] = map[R - 1][i + 1];
	// 3. 오른쪽
	for (int i = R - 1; i >= body; i--)
		map[i][C - 1] = map[i - 1][C - 1];
	// 4. 위쪽
	for (int i = C - 1; i > 1; i--)
		map[body][i] = map[body][i - 1];
	map[body][1] = 0;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> R >> C >> T;

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> map[i][j];
			if (map[i][j] == -1) {
				// 머리가 먼저 나올꺼니깐 머리부터 저장
				if (head == 0)
					head = i;
				else
					body = i;
			}
			else {
				dust_sum += map[i][j];	// 먼지의 최대량
			}
		}
	}
	while (T--) {
		dust();			// 먼지 확산되유
		air_cleaner();	// 공기청정기 돌아가유
	}
	cout << dust_sum << '\n';
}