#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int N, M, result = 99999;
int map[10][10], copyMap[10][10];

int dirx[] = { 0,1,0,-1 };
int diry[] = { -1,0,1,0 };

vector<pair<int, int>> cctv;
vector<int> angle;
bool visited[10][10][4]; // {y, x}, �ش� �������� ���� ���ΰ�


//1. ī�޶� ���Ϳ� �� ī�޶���� ������ ������ ���� �غ�
//2. dfs�� �� �ޱ۵��� ������ ����
//3. ������ �����Ǹ� ���մ�� ī�޶� �����ϰ� �ִ� ������ ǥ��
//4. �簢���� �ľ��ϰ� result�� �ݿ�

void print() {
	
	//for (int i = 1; i <= N; i++) {
	//	for (int j = 1; j <= M; j++) {
	//		cout << map[i][j] << " ";
	//	}
	//	cout << "\n";
	//}
	cout << "copy!" << "\n";
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cout << copyMap[i][j] << " ";
		}
		cout << "\n";
	}
}

// ���� �繫�� ����
void copy() {
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			copyMap[i][j] = map[i][j];
		}
	}
}

// �簢���� ���� �ľ�
int check() {
	int sum = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			if (copyMap[i][j] == 0)
				sum++;
		}
	}
	return sum;
}

// ���ջ���, ���տϼ��� ī�޶� �����ϰ��ִ� ������ ǥ��
void dfs(int cnt) {
	if (cnt == cctv.size()) {
		for (int i = 0; i < angle.size(); i++) {
			int y = cctv[i].first;
			int x = cctv[i].second;

			for (int k = 0; k < 4; k++) {
				if (visited[y][x][k]) {
					//cout << diry[angle[i] + k] % 4  <<", "<< dirx[angle[i] + k] % 4 << endl;
					int ny = y + diry[(angle[i] + k) % 4];
					int nx = x + dirx[(angle[i] + k) % 4];

					while (true) {
						// �� || ������
						if (copyMap[ny][nx] == 6)
							break;

						if(!(1 <= ny && ny <= N && 1 <= nx && nx <= M))
							break;

						// �簢���밡 �ƴϴ�
						if (copyMap[ny][nx] == 0)
							copyMap[ny][nx] = -1;

						ny += diry[(angle[i] + k) % 4];
						nx += dirx[(angle[i] + k) % 4];
					}
				}
			}
		}
		//print();
		result = min(result, check());
		copy();
		return;
	}

	for (int i = 0; i < 4; i++) {
		angle.push_back(i);
		dfs(cnt + 1);
		angle.pop_back();
	}
}

int main(void)
{
	cin >> N >> M;

	// �ܰ����� -2�� �ʱ�ȭ
	for (int i = 0; i <= 9; i++) {
		for (int j = 0; j <= 9; j++) {
			map[i][j] = -2;
		}
	}

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> map[i][j];

			// cctv �����
			if (1 <= map[i][j] && map[i][j] <= 5) {
				// ���� ī�޶������� ���󵵵�
				// ������ ��� ī�޶� 4�������� ������
				cctv.push_back({ i,j });	
			}

			switch (map[i][j])
			{
			case 1:
				visited[i][j][0] = true;
				break;
			case 2:
				visited[i][j][0] = true;
				visited[i][j][2] = true;
				break;
			case 3:
				visited[i][j][0] = true;
				visited[i][j][1] = true;
				break;
			case 4:
				visited[i][j][0] = true;
				visited[i][j][1] = true;
				visited[i][j][2] = true;
				break;
			case 5:
				visited[i][j][0] = true;
				visited[i][j][1] = true;
				visited[i][j][2] = true;
				visited[i][j][3] = true;
				break;

			}
		}
	}// eof input

	copy();
	dfs(0);
	cout << result;
}