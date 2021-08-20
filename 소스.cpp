#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int main() {
	int a, b = 0;
	long long answer = -1;
	cin >> a >> b;

	queue<pair<long long,int>> q;		// 숫자, 연산횟수
	bool flag = false;

	q.push({ a ,1 });

	while (!q.empty()) {
		long long n = q.front().first;
		int count = q.front().second;
		q.pop();
		
		if (n == b) {
			answer = count;
			break;
		}
		else if (n < b) {		// 작을때만 q에 넣어주면됨
			q.push({ n * 2 ,count + 1 });
			q.push({ n * 10 + 1 , count + 1 });
		}
	}

	cout << answer;
}
