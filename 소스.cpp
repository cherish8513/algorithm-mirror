#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int n, k, ans;
vector<int> v;

void dfs(int num, int ten)
{
	if (num > n) {
		return;
	}
	ans = max(ans, num);
	for (int i = 0; i < v.size(); i++) {
		dfs(num + ten * v[i], ten * 10);
	}
}

int main()
{
	cin >> n >> k;
	int input;
	for (int i = 0; i < k; i++) {
		int num;
		cin >> num;
		v.push_back(num);
	}
	dfs(0, 1);
	cout << ans;
	return 0;
}
