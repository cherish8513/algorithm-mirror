#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int C;

int answer = 1;

long long go(int a, int b) {
	if (b == 1) {
		return a;
	}
	else {
		if (b % 2 == 0)	// ¦���� �ݰ� 
			return (go(a, b / 2) * go(a, b / 2)) % C;
		else// Ȧ���� a �ϳ� �����
			return (((go(a, b / 2) * go(a, b / 2)) % C) * a) % C;
	}
}

int main() {
	int A, B;

	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> A >> B >> C;

	cout << go(A % C, B) % C;
}