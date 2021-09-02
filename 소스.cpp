#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int R, C, T;		// input
int map[51][51];	// ��
int copy_map[51][51];
int head, body;		// ����û���� �Ӹ��� ����
int dust_sum;		// answer

int dr[4] = { 0, 1, 0, -1 };
int dc[4] = { -1, 0, 1, 0 };

// ���� Ȯ��
void dust() {
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			// ������ �ִ���ҿ����� Ȯ��
			if (map[i][j] == 0 || map[i][j] == -1)
				continue;

			int dust_value = map[i][j] / 5;	// Ȯ��� �����ϳ��� ��
			int dust_cnt = 0;				// Ȯ��� ������ ����

			for (int k = 0; k < 4; k++) {
				int nr = i + dr[k];
				int nc = j + dc[k];

				// ���� ����� ���� �Ȼ���
				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				// ����û���� ������ ���� �Ȼ���
				if (map[nr][nc] == -1)
					continue;
				copy_map[nr][nc] += dust_value;	// 
				dust_cnt++;		// ���� ����+1
			}

			// ������ ���� * ������ �縸ŭ ����
			// �̸� ���־� ������Ʈ�Ҷ� ������ ������ ������.
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
	// ����û���� ��,�Ʒ�ĭ�� ������ ������ �������� �ȹ��
	// ������ ���Ɣf�� �̼����� ���Ƶ��̴°� �ٷ� ���Ʒ�ĭ ��
	dust_sum -= map[head - 1][0];	
	dust_sum -= map[body + 1][0];

	// ���� ���� ��ȯ, �����ȯ �ݴ�������� ��ȯ
	// 1. ���� 
	for (int i = head - 1; i > 0; i--) {
		map[i][0] = map[i - 1][0];
	}
	// 2. ����
	for (int i = 0; i < C - 1; i++) {
		map[0][i] = map[0][i + 1];
	}
	// 3. ������
	for (int i = 1; i <= head; i++) {
		map[i - 1][C - 1] = map[i][C - 1];
	}
	// 4. �Ʒ���
	for (int i = C - 1; i > 1; i--) {
		map[head][i] = map[head][i - 1];
	}
	map[head][1] = 0;	// �о �����̹Ƿ� ���ڸ��� ������ 0

	// �Ʒ� ���� ��ȯ
	// 1. ����
	for (int i = body + 1; i < R - 1; i++)
		map[i][0] = map[i + 1][0];
	// 2. �Ʒ���
	for (int i = 0; i < C - 1; i++)
		map[R - 1][i] = map[R - 1][i + 1];
	// 3. ������
	for (int i = R - 1; i >= body; i--)
		map[i][C - 1] = map[i - 1][C - 1];
	// 4. ����
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
				// �Ӹ��� ���� ���ò��ϱ� �Ӹ����� ����
				if (head == 0)
					head = i;
				else
					body = i;
			}
			else {
				dust_sum += map[i][j];	// ������ �ִ뷮
			}
		}
	}
	while (T--) {
		dust();			// ���� Ȯ�����
		air_cleaner();	// ����û���� ���ư���
	}
	cout << dust_sum << '\n';
}