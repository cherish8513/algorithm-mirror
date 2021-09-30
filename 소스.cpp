#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int N, K, answer = 0;
	cin >> N >> K;

	if (N <= K) cout << 0;
	else {
		while (1) {
			int cnt = 0;
			int temp = N;
			// 이렇게 돌리면 물병의 개수가 나옴
			// 5 % 2 => 1
			// 2 % 2 => 0
			// 1 % 2 => 1
			// => 2개
			//------------------------
			// 4 % 2 => 0
			// 2 % 2 => 0
			// 1 % 2 => 1
			while (temp > 0) {
				if (temp % 2 == 1) cnt++;
				temp /= 2;
			}

			if (cnt <= K) break;
			
			// 조건에 맞지않다면 물병1개 구매
			answer++;
			N++;
		}
		cout << answer; 
	}
}