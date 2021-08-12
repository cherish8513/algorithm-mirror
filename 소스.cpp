#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> v;
vector<int> cnt;
vector<int> answer;

void go(int cur, int depth, int plus, int minus, int mul, int div) {
	if (depth == v.size()) {
		answer.push_back(cur);
	}
	else {
		if (plus > 0) {
			go(cur + v[depth], depth + 1, plus - 1, minus, mul, div);
		}
		if (minus > 0) {
			go(cur - v[depth], depth + 1, plus, minus - 1, mul, div);
		}
		if (mul > 0) {
			go(cur * v[depth], depth + 1, plus, minus, mul - 1, div);
		}
		if (div > 0 && v[depth] != 0) {
			go(cur / v[depth], depth + 1, plus, minus, mul, div - 1);
		}
	}
}

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		v.push_back(num);
	}
	for (int i = 0; i < 4; i++) {
		int num;
		cin >> num;
		cnt.push_back(num);
	}

	go(v[0], 1, cnt[0], cnt[1], cnt[2], cnt[3]);

	cout << *max_element(answer.begin(), answer.end()) << endl;
	cout << *min_element(answer.begin(), answer.end()) << endl;
}