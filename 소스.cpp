#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int arr[401][401];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N; cin >> N;
	int M; cin >> M;

	for (int i = 0; i < M; i++) {
		int n1, n2;
		cin >> n1 >> n2;
		arr[n1][n2] = -1;
		arr[n2][n1] = 1;
	}

	// 플루이드 와샬
	for (int k = 1; k <= N; k++)
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				if (arr[i][k] == arr[k][j] && arr[i][k] != 0)
					arr[i][j] = arr[i][k];

	int s;
	cin >> s;
	for (int i = 0; i < s; i++) {
		int n1, n2;
		cin >> n1 >> n2;
		
		cout << arr[n1][n2] << '\n';
	}
}