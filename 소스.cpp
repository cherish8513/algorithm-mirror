#include <string>
#include <vector>
#include <iostream>

using namespace std;

const int MAX = 101;

long long A[MAX + 1][MAX + 1];
long long D[MAX + 1][MAX + 1];

int main() {
	int N;
	cin >> N;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> A[i][j];
		}
	}

	D[1][1] = 1;

	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < N + 1; j++) {
			if (D[i][j] == 0) continue;
			if (i == N && j == N) break;

			// 오
			if (j + A[i][j] < N + 1) {
				//cout << "오른쪽 : [" << i << ", " << j << "] 에서[" << i << ", " << j + A[i][j] << "] 로 점프" << endl;
				D[i][j + A[i][j]] += D[i][j];
			}

			// 아
			if (i + A[i][j] < N + 1) {
				//cout << "아래 : [" << i << ", " << j << "] 에서[" << i + A[i][j] << ", " << j << "] 로 점프" << endl;
				D[i + A[i][j]][j] += D[i][j];
			}
		}
	}
	//cout << endl;

	cout << D[N][N] << endl;
}