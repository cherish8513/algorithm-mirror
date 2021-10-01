#include <iostream>
#include <set>
#include <cmath>
#include <bitset>
#include <vector>

using namespace std;

// 1: �°� ž��
// 2: �°� ����
// 3: �°����� ��� ��ĭ�� �ڷ� �̵�
// 4: �°����� ��� ��ĭ�� ������ �̵�

int main() {
	int n, m;
	cin >> n >> m;

	// n���� ����
	vector<int> v(n + 1, 0);

	// m���� ���
	for (int i = 0; i < m; i++) {
		// ��� ��ȣ
		int cmd; cin >> cmd;	
		int train = 0, pos;

		switch (cmd)
		{
		// train��° ������ pos��ġ�� ž��
		case 1:
			cin >> train >> pos;
			// �ش� �ڸ����� or ����
			v[train] = v[train] | (int)pow(2, 20 - pos);
			break;
		// train��° ������ pos��ġ�� ����
		case 2:
			cin >> train >> pos;
			v[train] = v[train] & ~(int)pow(2, 20 - pos);
			break;
		//3,4�� �ܼ� ��Ʈ����
		case 3:
			cin >> train;
			v[train] = v[train] >> 1;
			break;
		// ���� ����Ʈ������ ������ 21��° ����� ����Ƿ� 21��° ��Ʈ�� ����
		case 4:
			cin >> train;
			v[train] = v[train] << 1;
			// 2^20 - 1 => 1111 1111 1111 1111 1111
			v[train] = v[train] & ((int)pow(2, 20) - 1);
			break;
		}
		/*bitset<20> bs(v[train]);
		cout <<train << " : "<< bs <<endl;*/
	}
	// set�� �־ �ߺ�����
	set<int> s;
	for (int i = 1; i <= n; i++) {
		s.insert(v[i]);
	}
	cout << s.size();
}