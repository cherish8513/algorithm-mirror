#include <vector>
#include <iostream>
#include <algorithm>
#define MAX_NUM 26

using namespace std;

int sum = 0;

int _x[] = { 0,0,1,-1 };		// dx
int _y[] = { 1,-1,0,0 };		// dy

int arr[MAX_NUM][MAX_NUM];		// 맵
bool check[MAX_NUM][MAX_NUM];	// 체크

void dfs(int y, int x, int n) {
	check[y][x] = true;			// 현재 위치는 방문 true
	sum++;

	for (int i = 0; i < 4; i++) {
		int ny = y + _y[i];
		int nx = x + _x[i];
		// 범위 + 미방문 위치일시 이동
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
				answer++;			// 단지 개수
				dfs(i, j, n);
				v.push_back(sum);	// 각 단지의 집 개수
			}
		}
	}

	cout << answer << endl;
	sort(v.begin(), v.end());		// 정렬
	for (auto& i : v) {
		cout << i << endl;
	}
}