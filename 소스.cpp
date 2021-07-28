#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int main() {
	int n;
	cin >> n;
	for (int tc = 0; tc < n; tc++) {
		unordered_map<int, int> um;
		vector<int> v;

		int answer = 0;
		int m;
		cin >> m;

		for (int i = 0; i < m / 2; i++) {
			int num1, num2;
			cin >> num1 >> num2;
			um[num1 + 1000]++;
		}

		for (int i = 0; i < m; i++) {
			int num;
			cin >> num;

			if (um.count(num) > 0)
				answer++;
		}
		cout << answer << endl;
	}
}