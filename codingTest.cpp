#include<iostream>
#include<string>
#include<stack>
using namespace std;
int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	while (1) {
		string input;
		bool flag = true;
		stack<char> stack;
		getline(cin, input);			// cin ���� space�� ���еż� �ۻ쳲
		if (input[0] == '.') break;
		for (int i = 0; input.length(); i++) {
			if (input[i] == '.') break;		// . ������ ���� ����
			else if (input[i] == '(') {		// ( �� ������ stack�� ����
				stack.push('(');
			}
			else if (input[i] == ')') {		// ) �� ������ �� ������ �� ���� ����ְų� ( �� �ƴϸ� �ߴ��ϰ� no ���
				if (stack.empty() || stack.top() != '(') {
					flag = false;
					break;
				}
				else {					//  �� ���� ��� pop ����
					stack.pop();
				}
			}
			else if (input[i] == '[') {		// ( �� ������ stack�� ����
				stack.push('[');
			}
			else if (input[i] == ']') {		// ] �� ������ �� ������ �� ���� ����ְų� [ �� �ƴϸ� �ߴ��ϰ� no ���
				if (stack.empty() || stack.top() != '[') {
					flag = false;
					break;
				}
				else {					//  �� ���� ��� pop ����
					stack.pop();
				}
			}
		}
		if (flag && stack.empty()) cout << "yes\n";		// ���� ����ְ� flag true �̸� yes
		else cout << "no\n";
	}
}