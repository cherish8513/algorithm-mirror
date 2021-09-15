#include<cstdio>
#define MAX 2188
using namespace std;

int map[MAX][MAX];
int result[3];
void divideCon(int size, int r, int c) {	

	for (int i = r; i < r + size; i++) {	
		for (int j = c; j < c + size; j++) {
			if (map[i][j] != map[r][c]) {		// 시작점과 값이 다르면 9분할
				for (int a = 0; a < 3; a++) {
					for (int b = 0; b < 3; b++) {
						divideCon(size / 3, r + a * size / 3, c + b * size / 3);
					}
				}
				return;		// 리턴하지 않으면 카운팅이 중복하여 될 수 있음
			}
		}
	}
	result[map[r][c] + 1]++;	// -1, 0, 1 이므로 +1을 하여 배열 3개에 카운팅
}

int main() {
	int N;
	scanf("%d", &N);
	
	for (int i = 1; i <= N; i++) {		// size / 3 하는 과정에서 손실되는 숫자가 나오지 않도록 1부터 시작
		for (int j = 1; j <= N; j++) {
			scanf("%d", &map[i][j]);
		}
	}

	divideCon(N, 1, 1);		// 탐색할 size와 가로 세로 시작 좌표를 넘김
	printf("%d\n%d\n%d\n", result[0], result[1], result[2]);
}