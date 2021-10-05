#include <queue>
#include <vector>
#include <iostream>
#include <algorithm>

#define INF 1e9

using namespace std;

/*
좋은생각이 안떠오른다...
바이러스 중에 m 개를 뽑아내면 조합이 너무 많은거아닌가
그렇게 많은조합으로 너비우선탐색을 전부돌린다?
이게 시간이 괜찮을까?
아 그래도 바이러스 개수가 10개이하라는 조건이 있구나
그럼 될거같기도?
10C5 가 10*9*8*7*6 = 30240 이니깐
30240 * bfs  <= 2500만 이면 가능할듯?
*/

int N, M, cnt_place, answer = INF;
int map[52][52];
int time[52][52];

int dx[] = { 0,0,1,-1 };
int dy[] = { 1,-1,0,0 };

class virus {
public:
	int x;
	int y;

	virus(int _x, int _y) {
		x = _x;
		y = _y;
	}
};

void time_init() {
	for (int i = 0; i <= N + 1; i++) {
		for (int j = 0; j <= N + 1; j++) {
			time[i][j] = -1;
		}
	}
}

void print() {
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cout << time[i][j] << " ";
		}
		cout << endl;
	}
}

int main() {
	cin >> N >> M;
	vector<virus> virus_vec;   // 바이러스 위치 저장(y,x)
	vector<int> v;            // 조합만들때 사용할 벡터

	for (int i = 0; i <= N + 1; i++) {
		for (int j = 0; j <= N + 1; j++) {
			// 태두리 벽으로 처리
			if (i == 0 || j == 0 || i == N + 1 || j == N + 1) {
				map[i][j] = 1;
			}
			// 그외에는 정상적으로 입력
			else {
				cin >> map[i][j];
				if (map[i][j] == 2) {
					virus_vec.push_back(virus(j, i));
					v.push_back(v.size() + 1);
				}
				else if (map[i][j] == 0) {
					cnt_place++;
				}
			}
		}
	}
	//eof input

	// 조합만들기 [ virus 개수에서 M개 뽑아내기 ]
	vector<int> temp;
	for (int i = 0; i < v.size(); i++)
		if (i < M)
			temp.push_back(1);
		else
			temp.push_back(0);

	sort(temp.begin(), temp.end());

	do {
		time_init();
		queue<virus> q;
		// 바이러스 선별
		for (int i = 0; i < temp.size(); i++) {
			if (temp[i] == 1) {
				q.push(virus_vec[i]);      // 바이러스 활성화
				time[virus_vec[i].y][virus_vec[i].x] = 0;	// 활성화된 바이러스는 0으로 시작
			}
		}

		int cnt_virus = 0;
		int total_time = 0;

		while (!q.empty()) {
			virus p = q.front();
			q.pop();

			int y = p.y;
			int x = p.x;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 벽일때는 전이 불가, 이미 바이러스가 전이된곳도 전이불가
				if (map[ny][nx] != 1 && time[ny][nx] == -1) {
					time[ny][nx] = time[y][x] + 1;
					if (map[ny][nx] == 0) {
						cnt_virus++;
						total_time = max(total_time, time[ny][nx]);
					}
					q.push(virus(nx, ny));
				}
			}
		}

		if (cnt_virus == cnt_place) {
			answer = min(answer, total_time);
			//cout << total_time<<", "<<answer<<"으ㅏ으ㅏ으ㅏ으ㅏ으아ㅡ아으ㅏ으" << endl << endl;
		}

	} while (next_permutation(temp.begin(), temp.end()));

	if (answer == INF) cout << -1 << endl;
	else cout << answer << endl;
}