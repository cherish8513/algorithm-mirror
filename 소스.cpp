#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int tc = 1;
	while (1) {
		// L : L일동안 사용가능
		// P : P일중에
		// V : 휴가 날짜
		int L, P, V;
		cin >> L >> P >> V;
		if (!L && !P && !V) { break; }	// 0 0 0 break

		int mod = (V % P) > L ? L : V % P;	// 사용가능한날 빼고나서 나머지
		int result = (V / P) * L + mod;
		cout << "Case " << tc++ << ": " << result << '\n';
	}
	return 0;
}
