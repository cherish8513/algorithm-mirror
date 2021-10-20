#include <queue>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int N, M;	// ����ũ��, ���ڰ���
int T;		// ȸ����
int arr[51][51];
bool del[51][51];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { -1,1,0,0 };
int check_cnt;	// ������ ���� ����� Ȯ��

void print() {
	cout << endl;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++)
			cout << arr[i][j] << " ";
		cout << endl;
	}
	cout << endl;
}

// ����, ����, ȸ��Ƚ��
void rotate(int x, int dir, int cnt) {
	// �ݽð���� ȸ���̶�� M-k ȸ������ �ٲ۴�
	// �ֳĸ� ȸ�� �ι��� ����� �����⶧��
	if (dir == 1)
		cnt = M - cnt;

	// �ð���� ȸ��
	for (int k = 0; k < cnt; k++) {
		int temp = arr[x][M - 1];
		for (int i = M - 1; i > 0; i--) {
			arr[x][i] = arr[x][i - 1];
		}
		arr[x][0] = temp;
	}
}

void check() {
	for (int y = 0; y < N; y++) {
		for (int x = 0; x < M; x++) {
			// �̹� ���������ڸ� Ȯ�� X
			if (arr[y][x] == 0)
				continue;

			for (int i = 0; i < 4; i++) {
				int nx = (x + dx[i]) % M;
				int ny = y + dy[i];

				if (ny >= N || y < 0)
					continue;

				// ����Ȯ��
				if (arr[y][x] == arr[ny][nx]) {
					del[y][x] = del[ny][nx] = true;
					check_cnt++;
				}
			}
		}
	}
}

void delet() {
	for (int y = 0; y < N; y++) {
		for (int x = 0; x < M; x++) {
			if (del[y][x])
				arr[y][x] = 0;
			del[y][x] = false;
		}
	}
}

void avg() {
	int cnt = 0;
	double avg = 0;
	for (int y = 0; y < N; y++) {
		for (int x = 0; x < M; x++) {
			avg += arr[y][x];
			if (arr[y][x] != 0)
				cnt++;
		}
	}
	avg /= cnt;

	for (int y = 0; y < N; y++) {
		for (int x = 0; x < M; x++) {
			if (arr[y][x] != 0) {
				// ��պ��� ������ +1, ũ�� -1
				if (arr[y][x] < avg) {
					arr[y][x] ++;
				}
				else if (arr[y][x] > avg) {
					arr[y][x]--;
				}
				// ? arr[y][x]++ : arr[y][x]--;
			}
		}
	}
}

int sum() {
	int sum = 0;
	for (int y = 0; y < N; y++)
		for (int x = 0; x < M; x++)
			sum += arr[y][x];

	return sum;
}

int main() {
	cin >> N >> M >> T;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
		}
	}// eof input

	for (int tc = 0; tc < T; tc++) {
		int x, d, k;
		cin >> x >> d >> k;

		for (int i = x; i <= N; i += x) {
			rotate(i - 1, d, k);
		}

		//print();
		check_cnt = 0;
		check();
		if (check_cnt == 0)
			avg();
		else
			delet();
		//print();
	}

	cout << sum();
}