#include<iostream>
#include<cmath>
#define endl "\n"
using namespace std;

bool prime[1000001];	// 초기값이 false니까 true인 숫자를 지운다. 즉 false가 소수

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int M, N;
	cin >> M >> N;
	prime[1] = true;
	for (int i = 2; i <= N / 2; i++) {	// i는 체크 하지 말아야 됨 어차피 4부터는 배수에 걸러져서 다 사라짐
		for (int j = i * 2; j <= N; j += i) {	
			prime[j] = true;	// 배수에 걸리는 애들 true로 소수에서 빼버리기
		}
	}

	for (int i = M; i <= N; i++) {
		if (prime[i]) continue;
		cout << i << endl;
	}
}