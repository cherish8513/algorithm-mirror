#include <iostream>

using namespace std;

long long tuemos(long long n) {
	if (n == 1) return 0;

	long long next = 1;
	// n���� �����Ҷ����� 2�� ����� �پ�ѱ�
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