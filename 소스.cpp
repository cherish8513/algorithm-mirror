#include <iostream>
#include <queue>
#include <string>

using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);


	queue<int> q;
	int N;
	cin >> N;

	// 전부 큐에 삽입
	for (int i = 1; i <= N; i++){
		q.push(i);
	}

	int i = 1;
	// 큐에 1장이 남을때까지 반복
	while(q.size() > 1){
		// 제일 위에 있는 카드를 버린다.
		if (i % 2 == 1) {
			q.pop();
		}
		// 제일 위에 있는 카드를 제일 아래로 옮긴다.
		else {
			q.push(q.front());
			q.pop();
		}
		i++;
	}
	cout << q.front();
}