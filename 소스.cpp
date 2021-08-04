#include <vector>
#include <iostream>
#include <algorithm>
#define MAX_NUM 26

using namespace std;

int sum = 0;

int _x[] = { 0,0,1,-1 };		// dx
int _y[] = { 1,-1,0,0 };		// dy

int arr[MAX_NUM][MAX_NUM];		// ��
bool check[MAX_NUM][MAX_NUM];	// üũ

void dfs(int y, int x, int n) {
	check[y][x] = true;			// ���� ��ġ�� �湮 true
	sum++;

	for (int i = 0; i < 4; i++) {
		int ny = y + _y[i];
		int nx = x + _x[i];
		// ���� + �̹湮 ��ġ�Ͻ� �̵�
		if (nx > 0 && ny > 0 && nx <= n && ny <= n && arr[ny][nx] == 1 && !check[ny][nx])
			dfs(ny, nx, n);
	}
}

int main() {
	int n; cin >> n;
	int answer = 0;
	vector<int> v;

	for (int i = 1; i <= n; i++) {
		string s; cin >> s;

		for (int j = 0; j < n; j++) {
			arr[i][j + 1] = s[j] - '0';
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (arr[i][j] == 1 && !check[i][j]) {
				sum = 0;
				answer++;			// ���� ����
				dfs(i, j, n);
				v.push_back(sum);	// �� ������ �� ����
			}
		}
	}

	cout << answer << endl;
	sort(v.begin(), v.end());		// ����
	for (auto& i : v) {
		cout << i << endl;
	}
}