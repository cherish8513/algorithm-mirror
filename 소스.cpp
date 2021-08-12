#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int answer = 0;
	int n; cin >> n;

	vector<int> v; 

	for (int i = 0; i < n; i++) {
		int num; cin >> num;
		v.push_back(num);
	}

	sort(v.begin(), v.end());

	do {
		int sum = 0;
		for (int i = 0; i < v.size() - 1; i++) {
			sum += abs(v[i] - v[i + 1]);
		}
		answer = answer > sum ? answer : sum;
	} while (next_permutation(v.begin(), v.end()));
	cout << answer;
}