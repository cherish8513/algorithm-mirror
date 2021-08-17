#include <iostream>

using namespace std;

int n, m, h;
int ladder[30][11];
bool check;
int cnt;

// y : y��ǥ, c : ����� ��ٸ� ����
void dfs(int y, int c) {
	if (check)		// �̹� ���� ã�Ҵٸ� return
		return;

	if (c == cnt)
	{
		bool flag = true;
		for (int i = 1; i <= n; i++) {
			int col = i;
			for (int j = 0; j < h; j++) {
				// ��ٸ��� ������ ���� �̵�
				if (ladder[j][col]) {
					col++;
				}
				else if (col > 1 && ladder[j][col - 1]) {
					col--;
				}
			}

			// ������ ��ġ�� �������� ���ߴٸ�
			if (i != col) {
				flag = false;
				break;
			}
		}
		// ���δ� ������ ��ġ�� �ö󰬴ٸ�
		if (flag) {
			check = true;
		}
			
		return;
	}

	for (int i = y; i < h; i++) {
		for (int j = 1; j < n; j++) {
			//�� ���μ��� �����ϰų� ���� ���ϸ� �ȵȴ�
			if (!ladder[i][j - 1] && !ladder[i][j] && !ladder[i][j + 1])
			{
				ladder[i][j] = true;
				dfs(i, c + 1);
				ladder[i][j] = false;
			}
		}
	}
		
	return;
}

int main() {
	cin >> n >> m >> h;

	for (int i = 0; i < m; i++) {
		int y, x;
		cin >> y >> x;
		// y���� x -> x+1 �� �̾��ִ� ��ٸ�
		ladder[y-1][x] = true;
	}

	// ��ٸ� 0~3�� ��ġ
	for (int i = 0; i <= 3; i++) {
		cnt = i;
		dfs(0, 0);
		if (check)
			break;
	}
	if (check) 
		cout << cnt;
	else 
		cout << -1;
}