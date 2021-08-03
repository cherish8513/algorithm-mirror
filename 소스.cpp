#include <iostream>
#include <vector>

using namespace std;

int N, M, answer = 0;
int map[101][101];	// 그래프
bool check[101];

void dfs(int current) {
	answer++;
	check[current] = true;	// 현재 컴퓨터는 방문함 

	for (int i = 1; i <= N; i++) {
		// 방문 안했고, 이어져있는 컴퓨터로 이동
		if (!check[i] && map[current][i] == 1) {
			dfs(i);
		}
	}
}

int main()
{
	// input
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int n1, n2;
		cin >> n1 >> n2;
		map[n1][n2] = 1;
		map[n2][n1] = 1;
	}
	// eof input

	// 1부터 탐색시작
	dfs(1);

	// 1번은 빼고 출력
	cout << answer - 1;
}
