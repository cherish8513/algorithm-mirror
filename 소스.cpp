#include<stdio.h>
#include<vector>
#include<algorithm>
using namespace std;

int n;
int map[25][25];		// 2���� �迭 �����̶� vector�� ��� ���ؼ� �ٸ� ����� ���
bool visited[25][25];
int complex = 1;		// ���� ���� ī����
int cnt;

bool dfs(int x, int y) {
	if (x < 0 || y < 0 || x >= n || y >= n) return false;	// ������ ����� false
	if (visited[x][y]) return false;						// �̹� �湮������ false
	visited[x][y] = true;									// �湮 ǥ�� but ���� ����Ʈ ������ ��
	if (map[x][y] > 0) {								// 0���� ũ�� ����Ʈ. ������ dfs ������� ī����
		cnt++;
		map[x][y] = complex;
		dfs(x + 1, y);									// ��ǥ�� Ž���� �Ѵ�. ���� ��ġ���� 4���� ��ͷ� Ž��
		dfs(x - 1, y);
		dfs(x, y + 1);
		dfs(x, y - 1);
		return true;								// ����Ʈ ���� �̹Ƿ� true ��ȯ
	}
	else
		return false;
	
}

int main() {
	scanf("%d", &n);
	vector<int> result;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%1d", &map[i][j]);
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (dfs(i, j)) {				// true�� ������ ����Ʈ ����
				complex++;					// ������ ī���� �ϱ����� 1 ����
				result.push_back(cnt);		// ���� ���� ��ä�� �־����� ī���� �� ���� ���Ϳ� ����
				cnt = 0;				// ���� ī������ ���� 0���� �ʱ�ȭ
			}
		}
	}
	sort(result.begin(), result.end());
	printf("%d\n", complex - 1);
	for (auto x : result) {
		printf("%d\n", x);
	}
	
}