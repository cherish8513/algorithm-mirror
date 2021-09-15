#include<cstdio>
#define MAX 2188
using namespace std;

int map[MAX][MAX];
int result[3];
void divideCon(int size, int r, int c) {	

	for (int i = r; i < r + size; i++) {	
		for (int j = c; j < c + size; j++) {
			if (map[i][j] != map[r][c]) {		// �������� ���� �ٸ��� 9����
				for (int a = 0; a < 3; a++) {
					for (int b = 0; b < 3; b++) {
						divideCon(size / 3, r + a * size / 3, c + b * size / 3);
					}
				}
				return;		// �������� ������ ī������ �ߺ��Ͽ� �� �� ����
			}
		}
	}
	result[map[r][c] + 1]++;	// -1, 0, 1 �̹Ƿ� +1�� �Ͽ� �迭 3���� ī����
}

int main() {
	int N;
	scanf("%d", &N);
	
	for (int i = 1; i <= N; i++) {		// size / 3 �ϴ� �������� �սǵǴ� ���ڰ� ������ �ʵ��� 1���� ����
		for (int j = 1; j <= N; j++) {
			scanf("%d", &map[i][j]);
		}
	}

	divideCon(N, 1, 1);		// Ž���� size�� ���� ���� ���� ��ǥ�� �ѱ�
	printf("%d\n%d\n%d\n", result[0], result[1], result[2]);
}