#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	while (true) {
		stack<int> strStack;
		string s;
		string answer;

		getline(cin, s);

		// '.' ���ڿ� ������ ��
		if (s[0] == '.') break;

		// ��ȣ�� '(' , ')' �׸��� '[' , ']' �μ�Ʈ
		for (auto& c : s) {
			// ���°�ȣ�� ����
			if (c == '(' || c == '[') {
				strStack.push(c);
			}
			// �ݴ°�ȣ��� stack top Ȯ��
			else if (c == ')' || c == ']') {
				// �˸��� ��ȣ�� target����
				char target = (c == ')') ? '(' : '[';

				// stack top�� ���� Ÿ�ٰ� ��ġ�Ѵٸ� stack pop
				if (!strStack.empty() && strStack.top() == target) {
					strStack.pop();
				}
				else {
					strStack.push(c);
				}
			}
		}
		if (strStack.empty())
			cout << "yes" << '\n';
		else
			cout << "no" << '\n';
	}
}