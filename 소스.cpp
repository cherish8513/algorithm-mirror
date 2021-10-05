#include <queue>
#include <vector>
#include <iostream>
#include <algorithm>

#define INF 1e9

using namespace std;

/*
���������� �ȶ�������...
���̷��� �߿� m ���� �̾Ƴ��� ������ �ʹ� �����žƴѰ�
�׷��� ������������ �ʺ�켱Ž���� ���ε�����?
�̰� �ð��� ��������?
�� �׷��� ���̷��� ������ 10�����϶�� ������ �ֱ���
�׷� �ɰŰ��⵵?
10C5 �� 10*9*8*7*6 = 30240 �̴ϱ�
30240 * bfs  <= 2500�� �̸� �����ҵ�?
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
	vector<virus> virus_vec;   // ���̷��� ��ġ ����(y,x)
	vector<int> v;            // ���ո��鶧 ����� ����

	for (int i = 0; i <= N + 1; i++) {
		for (int j = 0; j <= N + 1; j++) {
			// �µθ� ������ ó��
			if (i == 0 || j == 0 || i == N + 1 || j == N + 1) {
				map[i][j] = 1;
			}
			// �׿ܿ��� ���������� �Է�
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

	// ���ո���� [ virus �������� M�� �̾Ƴ��� ]
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
		// ���̷��� ����
		for (int i = 0; i < temp.size(); i++) {
			if (temp[i] == 1) {
				q.push(virus_vec[i]);      // ���̷��� Ȱ��ȭ
				time[virus_vec[i].y][virus_vec[i].x] = 0;	// Ȱ��ȭ�� ���̷����� 0���� ����
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

				// ���϶��� ���� �Ұ�, �̹� ���̷����� ���̵Ȱ��� ���̺Ұ�
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
			//cout << total_time<<", "<<answer<<"�������������������ƤѾ�������" << endl << endl;
		}

	} while (next_permutation(temp.begin(), temp.end()));

	if (answer == INF) cout << -1 << endl;
	else cout << answer << endl;
}