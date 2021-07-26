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

		// '.' 문자열 들어오면 끝
		if (s[0] == '.') break;

		// 괄호는 '(' , ')' 그리고 '[' , ']' 두세트
		for (auto& c : s) {
			// 여는괄호는 삽입
			if (c == '(' || c == '[') {
				strStack.push(c);
			}
			// 닫는괄호라면 stack top 확인
			else if (c == ')' || c == ']') {
				// 알맞은 괄호를 target으로
				char target = (c == ')') ? '(' : '[';

				// stack top이 현재 타겟과 일치한다면 stack pop
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