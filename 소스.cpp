#include <iostream> 
#include <vector> 
#include <queue>

using namespace std; 

int map[101][101];
bool flood[101][101];
bool visit[101][101];

int dx[] = { 0,0,1,-1 };
int dy[] = { 1,-1,0,0 };

int N, cnt, result = 1; 

void init() {
	cnt = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			flood[i][j] = false;
			visit[i][j] = false;
		}
	}
}

void dfs(int x, int y) {
	visit[y][x] = true;

	// 상하좌우
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx <= 0 || ny <= 0 || nx > N || ny > N)
			continue;

		// 방문안했고 침수가 안되어있다면 탐색 ㄱㄱ
		if (!visit[ny][nx] && !flood[ny][nx]) {
			dfs(nx, ny);
		}
	}
}

int main() { 
	cin >> N;

	int max = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
			max = max > map[i][j] ? max : map[i][j];
		}
	}

	// 최대값까지 수위를 높혀본다.
	for (int water_level = 2; water_level <= max; water_level++) {

		// 현재 수위
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 수위보다 작은 지역은 침수
				if (map[i][j] < water_level) {
					flood[i][j] = true;
				}
			}
		}
		
		// DFS
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!visit[i][j] && !flood[i][j]) {
					cnt++;
					dfs(j, i);
				}
			}
		}

		result = result > cnt ? result : cnt;
		init();
	}

	cout << result << endl;
}