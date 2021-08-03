#include<stdio.h>
#include<vector>
using namespace std;

vector<int> graph[101];		// 최대 컴퓨터가 100대까지 입력 된다 했으므로 인덱스 100까지 쓰기 위해 크기를 101로 잡음
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
	printf("%d\n", cnt - 1);		// 처음 1번은 포함하지 말아야 하므로 1 빼줌
}