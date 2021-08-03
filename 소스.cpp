#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N, M, V;
int map[1001][1001];
bool check[1001];

void dfs(int current) {
	check[current] = true;
	cout << current << ' ';

	for (int i = 1; i <= N; i++) {
		if (map[current][i] == 1 && !check[i]) {
			dfs(i);
		}
	}
}

void bfs(int current) {
	queue<int> q;
	q.push(current);
	// �����带 �湮ó��
	check[current] = true;

	// ť�� �������� �ݺ�
	while (!q.empty()) {
		int num = q.front();
		q.pop();
		cout << num << ' ';
		// ���� ����
		for (int i = 1; i <= N; i++) {
			if (map[num][i] == 1 && !check[i]) {
				q.push(i);
				check[i] = true;
			}
		}
	}
}

void init() {
	for (int i = 1; i <= N; i++) {
		check[i] = false;
	}
	cout << endl;
}


int main()
{
	cin >> N >> M >> V;

	for (int i = 0; i < M; i++) {
		int n1, n2;
		cin >> n1 >> n2;
		map[n1][n2] = 1;
		map[n2][n1] = 1;
	}

	
	dfs(V);
	init();
	bfs(V);
}
