#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main()
{
	stack<char> strStack;
	string s; cin >> s;

	int answer = 0;
	char pre = ' ';

	for (auto& current : s) {

		if (current == '(') {
			strStack.push(current);
		}
		else if (current == ')') {
			// ��ȣ�� ������ -> ���밡 �ϳ� �پ���.
			if (!strStack.empty() && strStack.top() == '(') {
				strStack.pop();

				// �ٷ� ������ ���� ��ȣ���ٸ� ������ ǥ��
				if (pre == '(') {
					answer += strStack.size();	// ���� ���� ũ�⸸ŭ ���밡 �� �����.
				}
				else {
					answer++;					// ���밡 ������ ���� ������ +1
				}
			}
		}

		pre = current;
	}
	cout << answer << endl;

}