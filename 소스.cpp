#include <iostream>
#include <stack>
using namespace std;

int main()
{
	int N; cin >> N;

	stack<int> stack;

	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;

		// push X: ���� X�� ���ÿ� �ִ� �����̴�.
		if (s.compare("push") == 0) {
			int num;
			cin >> num;
			stack.push(num);
		}
		// top: ������ ���� ���� �ִ� ������ ����Ѵ�. 
		// ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
		else if (s.compare("top") == 0) {
			if (stack.empty()) {
				cout << "-1\n";
			}
			else {
				cout << stack.top() << '\n';
			}
		}
		// size : ���ÿ� ����ִ� ������ ������ ����Ѵ�.
		else if (s.compare("size") == 0) {
			cout << stack.size() << '\n';
		}
		// empty : ������ ��������� 1, �ƴϸ� 0�� ����Ѵ�.
		else if (s.compare("empty") == 0) {
			if (stack.empty()) {
				cout << "1\n";
			}
			else {
				cout << "0\n";
			}
		}
		// pop: ���ÿ��� ���� ���� �ִ� ������ ����, �� ���� ����Ѵ�. 
		//���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
		else if (s.compare("pop") == 0) {
			if (stack.empty())
				cout << "-1\n";
			else {
				cout << stack.top() << '\n';
				stack.pop();
			}
		}
	}
}