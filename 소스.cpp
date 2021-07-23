#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main()
{
	int N;
	cin >> N;		// N <= 500,000

	stack<pair<int, int>> stack;
	vector<int> answer(N, 0);

	for (int i = 0; i < N; i++)
	{
		int height; 
		cin >> height;		
		pair<int, int> tower(height, i + 1);	// ����, index;

		while (true) {
			// ������ ����ٸ� �ڱ��ڽ��� ���� ū Ÿ��
			if (stack.empty()) {
				stack.push(tower);
				break;
			}
			// ����ž�� ��ũ�� answer�� ���� -> ���� �Է°�����, ���� Ǫ��
			else if(stack.top().first > height) {
				answer[i] = stack.top().second;
				stack.push(tower);
				break;
			}
			// ����ž�� �� ������ ���� Ÿ���� �� ũ�Ƿ� ����ž�� ����
			else {
				stack.pop();
			}
		}
	}

	for (int i = 0; i < N; i++) {
		cout << answer[i] << " ";
	}
}