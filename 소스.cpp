#include <iostream>
#include <vector>

using namespace std;

int N, M, answer = 0;
int map[101][101];	// �׷���
bool check[101];

void dfs(int current) {
	answer++;
	check[current] = true;	// ���� ��ǻ�ʹ� �湮�� 

	for (int i = 1; i <= N; i++) {
		// �湮 ���߰�, �̾����ִ� ��ǻ�ͷ� �̵�
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

	// 1���� Ž������
	dfs(1);

	// 1���� ���� ���
	cout << answer - 1;
}
