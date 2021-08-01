#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	string s;
	while (cin >> s) {
		bool no_per = true;
		int n, count = 0;
		cin >> n;

		string temp = s;
		sort(s.begin(), s.end());

		do {
			if (++count >= n) {
				no_per = false;
				cout << temp << " " << n << " = " << s <<"\n";
				break;
			}
		} while (next_permutation(s.begin(), s.end()));
		if(no_per)
			cout << temp << " " << n << " = No permutation\n";
	}
}