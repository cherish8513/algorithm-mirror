#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, answer;
int weight[9];
int dura[9];

void dfs(int current) {
	// 가장 최근에 든 계란이 가장 오른쪽인경우
	if (current >= n) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (dura[i] <= 0) cnt++;
		}
		if (answer < cnt)
			answer = cnt;
		return;
	}


	if (dura[current] <= 0) {
		dfs(current + 1);
	}
	else {
		bool check = false;
		for (int i = 0; i < n; i++)
		{
			// 자기자신이거나 이미 깨진 계란이면 넘어가기
			if (i == current || dura[i] <= 0) continue;

			// 계란 치기
			dura[current] = dura[current] - weight[i];	
			dura[i] = dura[i] - weight[current];
			check = true;

			dfs(current + 1);

			// dfs 이전 상황으로 복구
			dura[i] = dura[i] + weight[current];
			dura[current] = dura[current] + weight[i];
		}
		// 더이상 칠 계란이 없으면 마지막 계란으로
		if (!check)
			dfs(n);
	}
}

int main()
{
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> dura[i] >> weight[i];
	}
	dfs(0);
	cout << answer;
}