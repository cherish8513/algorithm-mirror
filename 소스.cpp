#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

#define CLEAN 2

using namespace std;

int result;
int n, m;		// ��ũ��
int y, x, d;	// �κ���ġ,����
int map[50][50];

// �ϵ�����
int dy[] = { -1,0,1,0 };
int dx[] = { 0,-1,0,1 };

// �ش� ������ ���� ����Ÿ��
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
		cout << x << ", " << y <<", "<<d<< "û�ҿϷ� -> ";
		// 1. ������ġ�� û���Ѵ�.
		if (map[y][x] == 0) {
			map[y][x] = CLEAN;
			result++;
		}

		// 2. ���� ��ġ���� ���� ������ �������� 
		// 2. ���� ������� ���ʴ�� ������ ĭ�� Ž���Ѵ�.
		bool temp = false;
		for (int k = 0; k < 4; k++) {
			int leftx = x + lx[(d + k) % 4];
			int lefty = y + ly[(d + k) % 4];
			// ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�
			if (map[lefty][leftx] == 0) {
				//cout << leftx << "," << lefty << " û���Ұ��� �߰� ";
				// �� �������� ȸ��
				d = (d + 1 + k) % 4;
				// ������ 1������
				y += dy[d];
				x += dx[d];
				temp = true;
				break;
			}
		}

		// �׹��� ��� û�Ұ� �Ǿ��ְų� ���ΰ�쿡��
		// �ٶ󺸴� ������ �����ϸ鼭 �ڷ� ����
		if (!temp) {
			if (map[y + dy[(d + 2) % 4]][x + dx[(d + 2) % 4]] == 1) {
				// �����Ϸ��µ� ���̸� ����
				cout << "����" << endl;
				break;
			}
			else {
				cout << "����" << endl;
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
// �� : 7
// �̶�µ� 5�ƴ� ??????
// ���������ٰ� ���������°� �����ʳ�