#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main()
{
	int N;
	cin >> N;

	vector<int> vec;			// ���� ���� �� ����(vector : ���� �迭)
	vector<int> answer(N, -1);	// ������ ������ ����
	stack<int> sta;				// ������ �ʿ��� ����

	// Input
	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		vec.push_back(num);
	}

	// Logic , �������� ����(������ ���ڸ� ���ؾ��ϱ� ����)
	for (int i = N - 1; i >= 0; i--) {
		int current = vec[i];

		// ���Ҽ��� �� ������ �ֺ������� �ݺ�
		while (!sta.empty()) {
			// stack top �� �ڱ⺸�� ũ�� ��ū���� ����
			if (sta.top() > current) {
				answer[i] = sta.top();
				break;
			}
			// stack top �� �ڱ⺸�� ������ �ʿ���� -> �ڱ� �ڽ��� ������ ���� ū �����̱� ����
			else {
				sta.pop();
			}
		}
		
		sta.push(vec[i]);
	}

	for (auto& i : answer) {
		cout << i << " ";
	}
}