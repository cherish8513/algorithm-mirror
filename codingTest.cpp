#include<stdio.h>
#include<vector>
using namespace std;

vector<int> graph[101];
bool visited[101];
int cnt = 0;

void dfs(int x) {
	visited[x] = true;
	cnt++;
	for (int i = 0; i < graph[x].size(); i++) {
		int y = graph[x][i];
		if (!visited[y])
			dfs(y);
	}
}

int main() {
	int v, e;
	scanf("%d %d", &v, &e);
	for (int i = 0; i < e; i++) {
		int x, y;
		scanf("%d %d", &x, &y);
		graph[x].push_back(y);
		graph[y].push_back(x);
	}

	dfs(1);
	printf("%d\n", cnt - 1);
}