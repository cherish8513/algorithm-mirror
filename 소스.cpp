#include <iostream>
using namespace std;

int n, m;
int map[1025][1025];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int num;
			cin >> num;
			// �ߺ��Ǵ� ����(dp ���� ������) �� ����� �������� ��������.
			map[i+1][j+1] = map[i+1][j] + map[i][j+1] - map[i][j] + num;
		}
	}	// eof input

	for (int i = 0; i < m; i++) {
		int x1, x2, y1, y2;
		cin >> y1 >> x1 >> y2 >> x2;
		
		// dp�� ���鶧�� �ݴ�� �ʿ���ºκ��� �����ϰ� �ߺ��Ǵ� ������ �����ش�.
		cout << map[y2][x2] - map[y1 - 1][x2] - map[y2][x1 - 1] + map[y1 - 1][x1 - 1] << '\n';
	}
}