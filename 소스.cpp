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
			// 괄호가 닫혔다 -> 막대가 하나 줄어든다.
			if (!strStack.empty() && strStack.top() == '(') {
				strStack.pop();

				// 바로 이전에 여는 괄호였다면 레이저 표시
				if (pre == '(') {
					answer += strStack.size();	// 현재 스택 크기만큼 막대가 더 생긴다.
				}
				else {
					answer++;					// 막대가 끝나도 막대 개수는 +1
				}
			}
		}

		pre = current;
	}
	cout << answer << endl;

}