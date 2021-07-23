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

		// push X: 정수 X를 스택에 넣는 연산이다.
		if (s.compare("push") == 0) {
			int num;
			cin >> num;
			stack.push(num);
		}
		// top: 스택의 가장 위에 있는 정수를 출력한다. 
		// 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		else if (s.compare("top") == 0) {
			if (stack.empty()) {
				cout << "-1\n";
			}
			else {
				cout << stack.top() << '\n';
			}
		}
		// size : 스택에 들어있는 정수의 개수를 출력한다.
		else if (s.compare("size") == 0) {
			cout << stack.size() << '\n';
		}
		// empty : 스택이 비어있으면 1, 아니면 0을 출력한다.
		else if (s.compare("empty") == 0) {
			if (stack.empty()) {
				cout << "1\n";
			}
			else {
				cout << "0\n";
			}
		}
		// pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 
		//만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
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