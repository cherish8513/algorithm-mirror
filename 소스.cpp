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
			// �̷��� ������ ������ ������ ����
			// 5 % 2 => 1
			// 2 % 2 => 0
			// 1 % 2 => 1
			// => 2��
			//------------------------
			// 4 % 2 => 0
			// 2 % 2 => 0
			// 1 % 2 => 1
			while (temp > 0) {
				if (temp % 2 == 1) cnt++;
				temp /= 2;
			}

			if (cnt <= K) break;
			
			// ���ǿ� �����ʴٸ� ����1�� ����
			answer++;
			N++;
		}
		cout << answer; 
	}
}