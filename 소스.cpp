#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int factorial(int n) {
	if (n == 0)
		return 0;
	if (n == 1)
		return 1;

	return factorial(n - 1) + factorial(n - 2);
}

int main() {
	int n;
	cin >> n;
	cout << factorial(n);
}