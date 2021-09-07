#include <iostream>

using namespace std;

long long tuemos(long long n) {
	if (n == 1) return 0;

	long long next = 1;
	// n까지 도달할때까지 2의 배수로 뛰어넘기
	for (int i = 1; 2 * next < n; i++) 
		next += next;
	
	return !tuemos(n - next);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long n;
	cin >> n;

	cout << tuemos(n);
}