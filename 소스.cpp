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

	// ���� ť�� ����
	for (int i = 1; i <= N; i++){
		q.push(i);
	}

	int i = 1;
	// ť�� 1���� ���������� �ݺ�
	while(q.size() > 1){
		// ���� ���� �ִ� ī�带 ������.
		if (i % 2 == 1) {
			q.pop();
		}
		// ���� ���� �ִ� ī�带 ���� �Ʒ��� �ű��.
		else {
			q.push(q.front());
			q.pop();
		}
		i++;
	}
	cout << q.front();
}