#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int tc = 1;
	while (1) {
		// L : L�ϵ��� ��밡��
		// P : P���߿�
		// V : �ް� ��¥
		int L, P, V;
		cin >> L >> P >> V;
		if (!L && !P && !V) { break; }	// 0 0 0 break

		int mod = (V % P) > L ? L : V % P;	// ��밡���ѳ� ������ ������
		int result = (V / P) * L + mod;
		cout << "Case " << tc++ << ": " << result << '\n';
	}
	return 0;
}
