#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, answer;
int weight[9];
int dura[9];

void dfs(int current) {
	// ���� �ֱٿ� �� ����� ���� �������ΰ��
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
			// �ڱ��ڽ��̰ų� �̹� ���� ����̸� �Ѿ��
			if (i == current || dura[i] <= 0) continue;

			// ��� ġ��
			dura[current] = dura[current] - weight[i];	
			dura[i] = dura[i] - weight[current];
			check = true;

			dfs(current + 1);

			// dfs ���� ��Ȳ���� ����
			dura[i] = dura[i] + weight[current];
			dura[current] = dura[current] + weight[i];
		}
		// ���̻� ĥ ����� ������ ������ �������
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