#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include <iomanip>

using namespace std;

int N, M;
int cheese_cnt;
vector<vector<int>> map;
vector<vector<int>> copy_map;

int dx[] = { 0,0,1,-1 };
int dy[] = { 1,-1,0,0 };

void print() {
	cout << endl << cheese_cnt << endl;
	for (auto& i : map) {
		for (auto& j : i) {
			cout << setw(3)<< j << " ";
		}
		cout << endl;
	}
}

// 1. 외부 공기인지 확인
void isOut() {
	queue<pair<int, int>> q;
	q.push({ 0, 0 });
	copy_map[0][0] = -1;

	while (!q.empty()) {
		pair<int, int> cur = q.front();
		q.pop();
		int x = cur.second;
		int y = cur.first;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위체크
			if (nx < 0 || ny < 0 || nx >= M || ny >= N) 
				continue;
			
			// 공기체크
			if (copy_map[ny][nx] != 0)
				continue;

			// 외부의 공기임을 -1로 체크
			copy_map[ny][nx] -= 1;
			// bfs 진행
			q.push({ ny,nx });
		}
	}

	//print();
}

// 2. 치즈를 녹인다.
void melt() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			// 치즈
			if (copy_map[i][j] == 1) {
				// 주변구역에 외부공기가 몇칸인지 확인
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = j + dx[k];
					int ny = i + dy[k];
					
					// 외부공기이면 cnt ++;
					if (copy_map[ny][nx] == -1) {
						cnt++;
					}
				}

				// 2개이상 접촉했다면
				if (cnt >= 2) {
					map[i][j] = 0;	
					cheese_cnt--;
				}
			}
		}
	}

	//print();
}

// copy_map으로 복사
void copy() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			copy_map[i][j] = map[i][j];
		}
	}
}

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		vector<int> v(M, 0);
		for (int j = 0; j < M; j++) {
			cin >> v[j];
			if (v[j] == 1)
				cheese_cnt++;
		}
		map.push_back(v);
		copy_map.push_back(v);
	}// eof input map

	int res = 0;
	while (cheese_cnt > 0) {
		isOut();
		melt();
		copy();
		res++;
		//print();
	}
	cout << res;
}