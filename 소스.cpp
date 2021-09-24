#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
	// ���� ���۽ð��� ���ð��� ������ �켱����ť
	priority_queue<pair<int, int> ,vector<pair<int,int>>, greater<pair<int,int>>> pq;
	// �� �����ð��� ���ð��� ������ �켱����ť -> �� ť�� ���� �� ���ǽ�
	priority_queue<int, vector<int>, greater<int>> endq;
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int start, end;
		cin >> start >> end;
		pq.push({start, end});
	}// eof input


	while (!pq.empty()) {
		// ���ĵ� ������ ���� ���ǽǿ� �����ϱ�
		pair<int, int> cur = pq.top(); pq.pop();

		// ���� ���ǽ��� ���ٸ� ���ο� ���ǽ��� ����
		if (endq.empty()) {
			endq.push(cur.second);
		}
		else {
			// �����ϴ� ���ǽ��� ����ð� �� �ּҰ���
			// ���� ������ ���۽ð��� ũ�ų� ���ٸ�
			// �ش� ���ǽǿ� �Ҵ簡�� -> �ð�����
			if (cur.first >= endq.top()) {
				endq.pop();
				endq.push(cur.second);
			}
			// �׷��� �ʴٸ�, ���ο� ���ǽǿ� ����
			else {
				endq.push(cur.second);
			}
		}
	}
	cout << endq.size();
	return 0;
}
