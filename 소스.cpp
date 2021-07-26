#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main()
{
	stack<int> s;

	int answer = 0;
	int k; cin >> k;

	for (int i = 0; i < k; i++) {
		int num; cin >> num;

		if (num > 0) {
			s.push(num);
		}
		else if(!s.empty()){
			s.pop();
		}
	}

	while(!s.empty()){
		answer += s.top();
		s.pop();
	}
	cout << answer;
}