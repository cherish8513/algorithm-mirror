#include <iostream>
#include <stack>
using namespace std;

int main()
{
	int n; cin >> n;

	for (int i = 0; i < n; i++) {
		stack<char> s;
		string str; cin >> str;

		for (auto& c : str) {
			// (
			if (c == '(') {
				s.push(c);
			}
			// )
			else {
				// 스택 top == ( 라면
				if (!s.empty() && s.top() == '(')
					s.pop();
				else
					s.push(c);
			}
		}

		if (s.empty())
			cout << "YES" << '\n';
		else
			cout << "NO" << '\n';
	}
}