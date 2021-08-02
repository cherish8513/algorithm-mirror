#include<stdio.h>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;
vector<int> graph[1001];
bool visitedD[1001];
bool visitedB[1001];

void dfs(int x) {
	visitedD[x] = true;
	printf("%d ", x);
	for (int i = 0; i < graph[x].size(); i++) {
		int y = graph[x][i];
		if (!visitedD[y])
			dfs(y);
	}

}

void bfs(int start) {
	queue<int> q;
	q.push(start);
	visitedB[start] = true;
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		printf("%d ", x);
		for (int i = 0; i < graph[x].size(); i++) {
			int y = graph[x][i];
			if (!visitedB[y]) {
				q.push(y);
				visitedB[y] = true;
			}
		}
	}
}

int main() {
	int n, m, v;
	scanf("%d %d %d", &n, &m, &v);
	for (int i = 0; i < m; i++) {
		int x, y;
		scanf("%d %d", &x, &y);
		graph[x].push_back(y);
		graph[y].push_back(x);
	}
	for (int i = 1; i <= n; i++) {
		sort(graph[i].begin(), graph[i].end());
	}
	dfs(v);
	printf("\n");
	bfs(v);
}